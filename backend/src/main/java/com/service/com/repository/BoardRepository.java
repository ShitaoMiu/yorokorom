package com.service.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.com.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	 Optional<Board> findByBoardId(String boardId);
} 