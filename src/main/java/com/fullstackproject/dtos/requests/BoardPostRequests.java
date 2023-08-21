package com.fullstackproject.dtos.requests;

import com.fullstackproject.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardPostRequests {
    String title;
    String content;
    String author;
}
