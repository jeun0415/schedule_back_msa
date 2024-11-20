package com.example.diaryService.service;

import com.example.diaryService.entity.*;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    DiaryImage saveDiaryImage(MultipartFile imageFile, Diary diary) throws Exception;
    ScheduleImage saveScheduleImage(MultipartFile imageFile, Schedule schedule) throws Exception;
    ProfileImage saveProfileImage(MultipartFile imageFile, User user) throws Exception ;
    String getProfileImage(Long idx);
    ProfileImage saveProfileImageFromUrl(byte[] imageBytes, User user);
}
