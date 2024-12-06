package com.example.userservice.dto.response;

import com.example.userservice.constant.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class DiaryResponseDayListDto {

    private Long idx;

    private String title;

    private String content;

    private LocalDate date;

    private Category category;

    private List<String> images;

}
