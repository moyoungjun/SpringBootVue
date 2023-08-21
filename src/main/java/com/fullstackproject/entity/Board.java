package com.fullstackproject.entity;

import com.fullstackproject.dtos.requests.BoardPostRequests;
import com.fullstackproject.dtos.requests.BoardUpdateRequests;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    public Board(BoardPostRequests requests) {
          new Board(idx, title = requests.getTitle(), content = requests.getContent(), author = requests.getAuthor());
    }

}
