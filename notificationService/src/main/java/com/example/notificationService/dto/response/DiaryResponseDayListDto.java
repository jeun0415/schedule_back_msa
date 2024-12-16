package com.example.friendservice.dto.response;

import com.example.friendservice.constant.Category;
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
