package com.fullstackproject.controller;

import com.fullstackproject.dtos.requests.BoardPostRequests;
import com.fullstackproject.dtos.requests.BoardUpdateRequests;
import com.fullstackproject.dtos.responses.BoardResponse;
import com.fullstackproject.entity.Board;
import com.fullstackproject.services.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public Page<BoardResponse> boardAll(Pageable pageable) {
        return boardService.boardAll(pageable);
    }

    @GetMapping("/{idx}")
    public BoardResponse boardDetail(@PathVariable Long idx) { return boardService.boardDetail(idx); }

    @PostMapping
    public BoardResponse boardPost(@RequestBody BoardPostRequests requests) {
        return boardService.boardPost(requests);
    }

    @PatchMapping
    public BoardResponse boardUpdate(@RequestBody BoardUpdateRequests requests) {return boardService.boardUpdate(requests);}

    @DeleteMapping("/{idx}")
    public void boardDelete(@PathVariable Long idx) { boardService.boardDelete(idx);}
}
