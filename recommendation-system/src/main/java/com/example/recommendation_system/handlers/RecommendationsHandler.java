package com.example.recommendation_system.handlers;

import org.springframework.stereotype.Service;
import com.example.recommendation_system.MessagePool;
import com.example.recommendation_system.entities.Recommendation;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendationsHandler {

    public List<Recommendation> getRecommendationsForNewReport( List<Recommendation> recOptions) {
        List<String> newReportSuggestions = Arrays.asList(MessagePool.OPEN_INVESTIGATION,
                                                          MessagePool.SAVE_FOR_LATE,
                                                          MessagePool.IGNORE_RECOMMENDATION);
        return fillRecommendationList(recOptions,newReportSuggestions);
    }

    private List<Recommendation> fillRecommendationList(List<Recommendation> recOptions, List<String> messages) {
        for (String message : messages)
                recOptions.add(new Recommendation(message));

        return recOptions;
    }

    public List<Recommendation> getRecommendationsForNewEvent(List<Recommendation> recommendationOptions) {
        List<String> newEventSuggestions = Arrays.asList(MessagePool.DISPLAY_CAR_DETAILS,
                                                          MessagePool.COLLECT_TRAFFIC_REPORTS,
                                                          MessagePool.DISPLAY_LOCATION_ON_MAP);
        return fillRecommendationList(recommendationOptions, newEventSuggestions);
    }
}
