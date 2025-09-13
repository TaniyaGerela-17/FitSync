package com.example.FitSync.services.workout;

import com.example.FitSync.dto.WorkoutDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WorkoutService {

    WorkoutDTO postWorkout(WorkoutDTO workoutDTO);

    List<WorkoutDTO> getWorkouts();
}
