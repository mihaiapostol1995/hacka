package com.recsystem.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recsystem.MessagePool;
import com.recsystem.RecommendationsHandler;
import com.recsystem.pojos.Recommendation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Component
public class RecommendationController {

    private final ObjectMapper mapper = new ObjectMapper();
    private final RecommendationsHandler handler = new RecommendationsHandler(mapper);

    public RecommendationController(){}

    List<Recommendation> recommendationOptions = new ArrayList<>();


    @GetMapping("/newReport/")
    //Analyst open new report in Omnix, invoking call from Omnix with indication of the opened report
    public List<Recommendation> handleNewReportFromOmnix() throws JsonProcessingException {
        clearRecommendationList();
        return handler.getRecommendationsForNewReport(recommendationOptions);
    }

    @GetMapping("/newEventStarted")
    //Analyst create new investigation - Type Event (data gathered from report), all data being filled automatically into the investigations
    public List<Recommendation> handleNewEventInvestigationFromOmnix() throws JsonProcessingException {
        clearRecommendationList();
        return handler.getRecommendationsForNewEvent(recommendationOptions);
    }


    @GetMapping("/clickOnCoffeeShop")
    //Analyst click on the coffee shop
    public Recommendation handleNewUserClick() {
        return new Recommendation(MessagePool.COLLECT_CREDIT_CARD_TRANSACTIONS);
    }

    private void clearRecommendationList(){
        recommendationOptions.clear();
    }


}
