package com.example.omnix.controllers;

import com.example.omnix.dtos.InvestigationData;
import com.example.omnix.dtos.Recommendation;
import com.example.omnix.proxies.RecommendationServiceProxy;
import com.example.omnix.responses.RecommendationSuggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AnalyticsController {

    private RecommendationServiceProxy recommendationServiceProxy;

    @Autowired
    public AnalyticsController(RecommendationServiceProxy recommendationServiceProxy) {
        this.recommendationServiceProxy = recommendationServiceProxy;
    }

    @PostMapping("/getReportResponse")
    public String getReportResponse(@RequestBody InvestigationData investigation) {
        System.out.println("Accident Report received by OMNIX.\nwaiting for suggestions from recommendation system.");

        RecommendationSuggestions recommendationSuggestions =
                recommendationServiceProxy.getReportResponse(investigation);
        System.out.println(recommendationSuggestions);
        return Arrays.toString(recommendationSuggestions.getSuggestions().toArray());
    }

    @PostMapping("/getEventSuggestions")
    public String getEventSuggestions(@RequestBody InvestigationData investigation){
        System.out.println("Accident data received by OMNIX.\nwaiting for suggestions from recommendation system.");

        RecommendationSuggestions recommendationSuggestions =
                recommendationServiceProxy.getEventResponse(investigation);
        System.out.println(recommendationSuggestions);
        return Arrays.toString(recommendationSuggestions.getSuggestions().toArray());
    }

    @GetMapping("/clickOnLocation")
    public String getLocationResponse(){
        RecommendationSuggestions recommendation = recommendationServiceProxy.handleNewUserClick();
        System.out.println(recommendation);
        return Arrays.toString(recommendation.getSuggestions().toArray());
    }
}
