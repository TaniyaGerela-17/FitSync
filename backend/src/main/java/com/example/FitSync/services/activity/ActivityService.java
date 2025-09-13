package com.example.FitSync.services.activity;

import com.example.FitSync.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {

    ActivityDTO postActivity(ActivityDTO dto);

    List<ActivityDTO> getActivities();
}
