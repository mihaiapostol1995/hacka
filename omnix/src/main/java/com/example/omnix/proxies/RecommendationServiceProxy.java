package com.example.omnix.proxies;


import com.example.omnix.dtos.Recommendation;
import com.example.omnix.responses.RecommendationSuggestions;
import org.springframework.cloud.openfeign.FeignClient;
import com.example.omnix.dtos.InvestigationData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="recommendation-system", url="localhost:8002")
public interface RecommendationServiceProxy {

    @PostMapping("/newReport")
    RecommendationSuggestions getReportResponse(InvestigationData investigationData);

    @PostMapping("/newEventStarted")
    RecommendationSuggestions getEventResponse(InvestigationData investigationData);

    @GetMapping("/clickOnCoffeeShop")
    Recommendation handleNewUserClick();
}
