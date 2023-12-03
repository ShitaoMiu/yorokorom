package com.service.com.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.com.domain.Board;
import com.service.com.repository.BoardRepository;
import com.service.com.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	public Optional<Board> findBoard(String boardId) {
 		return boardRepository.findByBoardId(boardId);
	}
 
 
}
