package com.example.omnix.controllers;

import com.example.omnix.dtos.InvestigationData;
import com.example.omnix.proxies.RecommendationServiceProxy;
import com.example.omnix.responses.RecommendationSuggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnalyticsController {

    private RecommendationServiceProxy recommendationServiceProxy;

    @Autowired
    public AnalyticsController(RecommendationServiceProxy recommendationServiceProxy) {
        this.recommendationServiceProxy = recommendationServiceProxy;
    }

    @PostMapping("/getReportResponse")
    public List<String> getReportResponse(@RequestBody InvestigationData investigation){
        System.out.println("Report data received by OMNIX: " + investigation.getData());
        RecommendationSuggestions recommendationSuggestions =
                recommendationServiceProxy.getReportResponse(investigation);
        System.out.println(recommendationSuggestions);
        return recommendationSuggestions.getSuggestions();
    }

    @PostMapping("/getEventSuggestions")
    public List<String> getEventSuggestions(@RequestBody InvestigationData investigation){
        List<String> eventSuggestions =
                recommendationServiceProxy.getEventResponse(investigation);
        System.out.println(eventSuggestions);
        return eventSuggestions;
    }
}
