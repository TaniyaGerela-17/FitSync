package com.example.FitSync.services.goal;

import com.example.FitSync.dto.GoalDTO;

import java.util.List;

public interface GoalService {

    GoalDTO postGoal(GoalDTO dto);

    List<GoalDTO> getGoals();

    GoalDTO updateStatus(Long id);
}
