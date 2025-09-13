package com.example.FitSync.services.stats;

import com.example.FitSync.Entity.Activity;
import com.example.FitSync.Entity.Workout;
import com.example.FitSync.Repository.ActivityRepository;
import com.example.FitSync.Repository.GoalRepository;
import com.example.FitSync.Repository.WorkoutRepository;
import com.example.FitSync.dto.GraphDTO;
import com.example.FitSync.dto.StatsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsServiceImpl implements StatsService{

    private final GoalRepository goalRepository;

    private final ActivityRepository activityRepository;

    private final WorkoutRepository workoutRepository;


    @Autowired
    public StatsServiceImpl(GoalRepository goalRepository,ActivityRepository activityRepository, WorkoutRepository workoutRepository) {
        this.goalRepository = goalRepository;
        this.activityRepository = activityRepository;
        this.workoutRepository = workoutRepository;
    }


    public StatsDTO getStats(){
//        Fetch goals count
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalActivityCalories();

        Integer totalWorkoutDuration = workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0) + (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0);

        StatsDTO dto = new StatsDTO();
        dto.setAchievedGoals(achievedGoals !=null ? achievedGoals : 0);
        dto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0);

        dto.setSteps(totalSteps !=null ? totalSteps : 0);
        dto.setDistance(totalDistance != null ? totalDistance : 0.0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);
        dto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);

        return dto;
    }

    public GraphDTO getGraphStats(){
        Pageable pageable = PageRequest.of(0,7);

        List<Workout> workouts = workoutRepository.findLast7Workouts(pageable);
        List<Activity> activities = activityRepository.findLast7Activities(pageable);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));

        return graphDTO;
    }
}
