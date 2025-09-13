package com.example.FitSync.services.workout;

import com.example.FitSync.Entity.Workout;
import com.example.FitSync.Repository.WorkoutRepository;
import com.example.FitSync.dto.WorkoutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();

        workout.setDate(workoutDTO.getDate());
        workout.setType(workoutDTO.getType());
        workout.setDuration(workoutDTO.getDuration());
        workout.setCaloriesBurned(workoutDTO.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDto();
    }

    public List<WorkoutDTO> getWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();

        return workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList());
    }
}
