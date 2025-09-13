package com.example.FitSync.dto;

import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    public List<WorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ActivityDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDTO> activities) {
        this.activities = activities;
    }

    private List<WorkoutDTO> workouts;

    private List<ActivityDTO> activities;
}
