package com.example.friendservice.dto.response;

import com.example.friendservice.constant.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsMonthDto {

    private String date;
    private Long diaryCount;
    private Long cumulativeDiaryCount;
    private Double totalPercentage;
    private Map<Category, Double> CategoryPercentageMap;
}
