package com.example.FitSync.Controller;

import com.example.FitSync.dto.WorkoutDTO;
import com.example.FitSync.services.workout.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDTO workoutDTO){
        try {
            return ResponseEntity.ok(workoutService.postWorkout(workoutDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
        }
    }

    @GetMapping("/workouts")
    public ResponseEntity<?> getWorkouts(){
        try{
            return ResponseEntity.ok(workoutService.getWorkouts());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong.");
        }
    }
}
