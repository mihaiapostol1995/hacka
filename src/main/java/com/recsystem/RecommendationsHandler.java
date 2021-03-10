package com.recsystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recsystem.pojos.Recommendation;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendationsHandler {

    ObjectMapper mapper;
    public RecommendationsHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Recommendation> getRecommendationsForNewReport(List<Recommendation> recOptions)
            throws JsonProcessingException {
        List<String> newReportSuggestions = Arrays.asList(MessagePool.OPEN_INVESTIGATION,
                                                          MessagePool.SAVE_FOR_LATE,
                                                          MessagePool.IGNORE_RECOMMENDATION);
        return fillRecommendationList(recOptions,newReportSuggestions);
    }

    private List<Recommendation> fillRecommendationList(List<Recommendation> recOptions, List<String> messages)
            throws JsonProcessingException {
        for (String message : messages)
                recOptions.add(new Recommendation(message));
        mapper.writeValueAsString(recOptions);

        return recOptions;
    }
    public List<Recommendation> getRecommendationsForNewEvent(List<Recommendation> recommendationOptions)
            throws JsonProcessingException {
        List<String> newEventSuggestions = Arrays.asList(MessagePool.DISPLAY_CAR_DETAILS,
                                                          MessagePool.COLLECT_TRAFFIC_REPORTS,
                                                          MessagePool.DISPLAY_LOCATION_ON_MAP);
        return fillRecommendationList(recommendationOptions,newEventSuggestions);
    }
}
