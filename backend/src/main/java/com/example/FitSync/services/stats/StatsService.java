package com.example.FitSync.services.stats;

import com.example.FitSync.dto.GraphDTO;
import com.example.FitSync.dto.StatsDTO;

public interface StatsService {

    StatsDTO getStats();

    GraphDTO getGraphStats();
}
