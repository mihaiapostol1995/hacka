package com.example.recommendation_system.responses;

import lombok.Data;

import java.util.List;

@Data
public class RecommendationSuggestions {
    List<String> suggestions;
}
