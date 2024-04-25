package org.applicationtest.springboot.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class NoticeDTO {
    private Long no;
    private String title;
    private String content;
    private Long count;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
