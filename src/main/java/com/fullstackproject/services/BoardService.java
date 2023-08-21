package com.fullstackproject.services;

import com.fullstackproject.dtos.requests.BoardPostRequests;
import com.fullstackproject.dtos.requests.BoardUpdateRequests;
import com.fullstackproject.dtos.responses.BoardResponse;
import com.fullstackproject.entity.Board;
import com.fullstackproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponse> boardAll() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream().
                map(board -> new BoardResponse().toBoardResponse(board)).toList();
    }

    public BoardResponse boardDetail(Long idx) {
        Board boardDetail = boardRepository.findById(idx).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return new BoardResponse().toBoardResponse(boardDetail);
    }

    public BoardResponse boardPost(BoardPostRequests boardPostRequests) {
        Board board = new Board(boardPostRequests);
        boardRepository.save(board);
        return new BoardResponse().toBoardResponse(board);
    }

    public BoardResponse boardUpdate(BoardUpdateRequests boardUpdateRequests) {
        Board board = boardRepository.findById(boardUpdateRequests.getIdx()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        board.setTitle(boardUpdateRequests.getTitle());
        board.setContent(boardUpdateRequests.getContent());
        return  new BoardResponse().toBoardResponse(boardRepository.save(board));
    }

    public void boardDelete(Long idx) {
        Board board = boardRepository.findById(idx).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        boardRepository.delete(board);
    }
}
