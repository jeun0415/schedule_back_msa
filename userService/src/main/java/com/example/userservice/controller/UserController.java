package com.example.userservice.controller;

import com.example.userservice.dto.request.UserInfoDto;
import com.example.userservice.dto.request.UserRequestUpdateDto;
import com.example.userservice.dto.response.UserSearchResponseDto;
import com.example.userservice.service.ImageService;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ImageService imageService;

    //유저 닉네임 수정
    @PutMapping(value = "/updateUserName")
    public ResponseEntity<String> updateUserName(
                                                 @RequestBody UserRequestUpdateDto userRequestUpdateDto){
        userService.updateUserName(userRequestUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body("UserNickname updated successfully");
    }

    //유저 프로필 이미지 수정
    @PostMapping(value = "/updateProfileImage/{idx}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateProfileImage(@PathVariable(name = "idx") Long idx,
                                                     @RequestPart(name = "imageFiles") MultipartFile imageFile) {
        System.out.println("Received file name: " + imageFile.getOriginalFilename());
        System.out.println("Received file size: " + imageFile.getSize());
        userService.updateProfileImage(idx, imageFile);
        return ResponseEntity.status(HttpStatus.OK).body("Profile updated successfully");
    }

    //유저 프로필 조회
    @GetMapping(value = "/profileImage/{idx}")
    public ResponseEntity<String> getProfileImage(@PathVariable(name = "idx") Long idx) {
        String imageUrl = imageService.getProfileImage(idx); // 서비스 메서드 호출
        return ResponseEntity.ok(imageUrl); // 이미지 URL 반환
    }

    @DeleteMapping(value = "/delete/{email}")
    public ResponseEntity<String> deleteByUser(
            @PathVariable(name = "email") String email,
            @RequestHeader(name = "Authorization") String token) {
        String authToken = token.replace("Bearer ", "");

        userService.deleteUser(email, authToken);
        return ResponseEntity.status(HttpStatus.OK).body("Success Delete Account");
    }

    // 유저 검색
    @GetMapping(value = "/search")
    public List<UserSearchResponseDto> searchUsers(@RequestParam String userName, @RequestParam List<Long> friendIds) {

        return userService.searchUserByUserName(userName, friendIds);
    }

    // 친구 요청 목록 조회
    @GetMapping(value = "/request")
    private List<UserSearchResponseDto> friendRequestList(@RequestParam List<Long> friendId){
        List<UserSearchResponseDto> friendListId = userService.searchRequester(friendId);
        return friendListId;
    }

    @GetMapping("/friends")
    public List<UserSearchResponseDto> getFriendsList(@RequestParam List<Long> friendsId) {
        List<UserSearchResponseDto> friends = userService.searchFriend(friendsId);
        return friends;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoDto> getUserInfo(@PathVariable(name = "userId") Long userId) {
        UserInfoDto userInfo = userService.getUserById(userId);
        return ResponseEntity.ok(userInfo);
    }


    // userName 조회(Feign)
    @GetMapping("/name/{userIdx}")
    public String getUserName(@PathVariable(name = "userIdx") Long userIdx){
        return userService.getUserName(userIdx);
    }
}

