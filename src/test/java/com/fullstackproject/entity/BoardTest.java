package com.fullstackproject.entity;

import com.fullstackproject.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void tableTest() throws Exception {
        Board board = new Board(1L,"title","content","author");

        Board bo = boardRepository.save(board);
        Board bofi = boardRepository.findById(bo.getIdx()).orElseThrow();

        assertEquals(bo,bofi);

    }

    @Test
    public void tableTest2() throws Exception {
        List<Board> bo = boardRepository.findAll();
        System.out.println(bo);
    }
}