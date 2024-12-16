package com.example.calendarservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_idx")
    private Long commentsIdx;

    @Column(name = "u_idx")
    private Long userIdx;

    @Column(name = "s_idx")
    private Long scheduleIdx;

    @Column(name = "d_idx")
    private Long diaryIdx;

    @Column(name = "com_date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "com_content")
    private String content;
}