package com.example.friendservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendListResponseDto {

    private Long idx;

    private String userName;

}