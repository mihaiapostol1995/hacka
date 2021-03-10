package com.example.recommendation_system.controllers;

import com.example.recommendation_system.dtos.InvestigationData;
import com.example.recommendation_system.responses.RecommendationSuggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.recommendation_system.entities.Recommendation;
import com.example.recommendation_system.handlers.RecommendationsHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecommendationController {

    private RecommendationsHandler handler;

    List<Recommendation> recommendationOptions = new ArrayList<>();

    @Autowired
    public void setRecommnendationsHandler (RecommendationsHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/newReport")
    //Analyst open new report in Omnix, invoking call from Omnix with indication of the opened report
    public RecommendationSuggestions handleNewReportFromOmnix(@RequestBody InvestigationData investigationData){
        clearRecommendationList();
        System.out.println("Recommendation System received report data: " + investigationData.getData());
        RecommendationSuggestions recommendationSuggestions = new RecommendationSuggestions();
        recommendationSuggestions.setSuggestions(handler
                .getRecommendationsForNewReport(recommendationOptions)
                .stream()
                .map(Recommendation::getText)
                .collect(Collectors.toList()));
        return recommendationSuggestions;
    }

    @PostMapping("/newEventStarted")
    //Analyst create new investigation - Type Event (data gathered from report), all data being filled automatically into the investigations
    public RecommendationSuggestions handleNewEventInvestigationFromOmnix(@RequestBody InvestigationData investigationData){
        clearRecommendationList();
        System.out.println("Recommendation system received event data: " + investigationData);
        RecommendationSuggestions recommendationSuggestions = new RecommendationSuggestions();
        recommendationSuggestions.setSuggestions(handler
                .getRecommendationsForNewEvent(recommendationOptions)
                .stream()
                .map(Recommendation::getText)
                .collect(Collectors.toList()));
        return recommendationSuggestions;
    }

    private void clearRecommendationList(){
        recommendationOptions.clear();
    }


}