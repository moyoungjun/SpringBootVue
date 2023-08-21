package com.fullstackproject.dtos.responses;

import com.fullstackproject.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {
    private Long idx;
    private String title;
    private String content;
    private String author;
    private String created_at;
    private String updated_at;

    public BoardResponse toBoardResponse(Board board) {
        return new BoardResponse(
                board.getIdx(),
                board.getTitle(),
                board.getContent(),
                board.getAuthor(),
                board.getCreated_at().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                board.getUpdated_at().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                );
    }

    public BoardResponse(Board board) {
        this.idx = board.getIdx();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
        this.created_at = board.getCreated_at().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        this.updated_at = board.getUpdated_at().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }
}
