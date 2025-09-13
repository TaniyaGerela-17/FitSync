package com.example.FitSync.Entity;

import com.example.FitSync.dto.ActivityDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Activity {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private int steps;

    private double distance;

    private int caloriesBurned;

    private String duration;

    public ActivityDTO getActivityDTO(){
        ActivityDTO activityDTO = new ActivityDTO();

        activityDTO.setId(id);
        activityDTO.setDate(date);
        activityDTO.setSteps(steps);
        activityDTO.setDistance(distance);
        activityDTO.setCaloriesBurned(caloriesBurned);
        activityDTO.setDuration(duration);

        return activityDTO;
    }
}
