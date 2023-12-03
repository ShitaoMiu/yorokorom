package com.service.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.com.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
	Optional<Post> findByPostId(String postId);
	@Query("SELECT p from Post p WHERE p.board.boardId=:boardId ORDER BY p.regDate DESC")
	List<Post> findByBoardIdOrderByRegDateDesc();
	void deleteByPostId(String postId);

}