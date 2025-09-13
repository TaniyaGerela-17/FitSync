package com.example.FitSync.dto;

import lombok.Data;

@Data
public class StatsDTO {

    private long achievedGoals;

    public long getAchievedGoals() {
        return achievedGoals;
    }

    public void setAchievedGoals(long achievedGoals) {
        this.achievedGoals = achievedGoals;
    }

    public long getNotAchievedGoals() {
        return notAchievedGoals;
    }

    public void setNotAchievedGoals(long notAchievedGoals) {
        this.notAchievedGoals = notAchievedGoals;
    }

    private long notAchievedGoals;

    private int steps;

    private Double distance;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public int getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(int totalCaloriesBurned) {
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    private int totalCaloriesBurned;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;
}
