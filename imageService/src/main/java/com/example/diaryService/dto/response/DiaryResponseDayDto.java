package com.example.diaryService.dto.response;

import com.example.diaryService.constant.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class DiaryResponseDayDto {

    private String title;

    private String content;

    private LocalDate date;

    private Category category;

    private List<String> images;

    private List<Long> ids;

}
