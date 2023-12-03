package com.service.com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.com.domain.Board;
import com.service.com.domain.Post;
import com.service.com.repository.BoardRepository;
import com.service.com.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository;
	private final BoardRepository boardRepository;
 
	@Transactional
	public String updatePost(String boardId, Post post) {
		System.out.println("boardId:::::::::::::::::::::"+boardId);
		Post newPost=  new Post();
		newPost.setPostId(post.getPostId());
		newPost.setPostContent(post.getPostContent());
		newPost.setPostTitle(post.getPostTitle());
		newPost.setRegId(post.getRegId());
		newPost.setRegDate(LocalDateTime.now());
		
		Optional<Board>  opBoard=  boardRepository.findByBoardId(boardId);
		Board board = opBoard.get();
		newPost.setBoard(board);
		board.getPosts().add(newPost);
		postRepository.save(newPost);
		return newPost.getPostId();
	}
	
	@Transactional
	public String createPost(String boardId, Post post) {
		//새번호 만들기
		String maxPostId = postRepository.findByBoardIdOrderByRegDateDesc().get(0).getPostId();
		int nextPostId = Integer.parseInt(maxPostId)+1;
		String newPostId = String.format("%04d", nextPostId);
		System.out.println("새번호"+newPostId);
		post.setPostId(newPostId);
		
		Optional<Board>  opBoard=  boardRepository.findByBoardId(boardId);
		Board board = opBoard.get();
		post.setBoard(board);
		board.getPosts().add(post);
		postRepository.save(post);
		return post.getPostId();
	}

	public Post findPost(String postId) {
		Post post = postRepository.findByPostId(postId).orElse(null) ;
		return post;
	}
	@Transactional
	public void deletePost(String postId) {
		postRepository.deleteByPostId(postId);
	}
}
