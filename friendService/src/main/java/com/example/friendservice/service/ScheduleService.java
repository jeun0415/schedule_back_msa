package com.example.friendservice.service;

import com.example.friendservice.dto.request.ScheduleRequestInsertDto;
import com.example.friendservice.dto.request.ScheduleRequestUpdateDto;
import com.example.friendservice.dto.response.ScheduleResponseDayDto;
import com.example.friendservice.dto.response.ScheduleResponseMonthDto;
import com.example.friendservice.dto.response.ScheduleResponseYearDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ScheduleService {

    List<ScheduleResponseYearDto> findAllYearSchedule(Long calendarIdx, int year);
    List<ScheduleResponseMonthDto> findAllMonthSchedule(Long calendarIdx, int year, int month);
    List<ScheduleResponseDayDto> findScheduleByDay(Long calendarIdx, int year, int month, int day);
    ScheduleResponseDayDto findScheduleByOne(Long scheduleIdx);

    void saveSchedule(ScheduleRequestInsertDto scheduleRequestInsertDto, List<MultipartFile> imageFileList);
    void updateSchedule(ScheduleRequestUpdateDto scheduleRequestUpdateDto,List<MultipartFile> imageFileList);
    void deleteSchedule(Long scheduleId, boolean deleteAllRepeats, boolean deleteOnlyThis, boolean deleteAfter);
}