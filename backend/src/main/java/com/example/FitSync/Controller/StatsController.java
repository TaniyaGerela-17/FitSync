package com.example.FitSync.Controller;


import com.example.FitSync.dto.GraphDTO;
import com.example.FitSync.services.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StatsController {

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    private final StatsService statsService;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats(){
        GraphDTO graphDTO = statsService.getGraphStats();

        if (graphDTO != null){
            return ResponseEntity.ok(graphDTO);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
