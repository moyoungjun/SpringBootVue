package com.fullstackproject.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private Long idx;
    private String title;
    private String content;
    private String author;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
