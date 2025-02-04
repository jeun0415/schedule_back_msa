package com.example.calendarservice.dto.response;

import com.example.calendarservice.constant.RepeatType;
import com.example.calendarservice.constant.Share;
import com.example.calendarservice.entity.DiaryImage;
import com.example.calendarservice.entity.ScheduleImage;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SharedContentDto {
    private Long sharedIdx;
    private LocalDateTime shareDate;
    private String type;
    private String title;
    private String content;
    private String category;
    private String location;
    private String author;
    private Long authorIdx;

    private Long scheduleIdx;
    private Long diaryIdx;

    private LocalDateTime start;
    private LocalDateTime end;
    private RepeatType repeatType;
    private LocalDate repeatEndDate;
    private LocalDate date;

    private List<String> scheduleImages;
    private List<String> diaryImages;

    private Share share;
}
