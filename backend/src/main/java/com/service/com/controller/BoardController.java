package com.service.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.com.domain.Board;
import com.service.com.domain.Post;
import com.service.com.dto.Message;
import com.service.com.dto.StringMessage;
import com.service.com.enums.StatusEnum;
import com.service.com.service.BoardService;
import com.service.com.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class BoardController {
	private final BoardService boardService;
	private final PostService postService;

	@GetMapping("/board/{boardId}")
	public ResponseEntity<Message> getPosts(@PathVariable String boardId) {
		Message message = new Message();
		List<Post> posts = boardService.findBoard(boardId).get().getPosts();
		message.setStatus(StatusEnum.OK);
		message.setMessage(StringMessage.workComplete);
		message.setData(posts);
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);
	}

	@GetMapping("/board/{boardId}/post/{postId}")
	public ResponseEntity<Message> getPosts(@PathVariable String boardId, @PathVariable String postId) {
		Message message = new Message();
		Post post = postService.findPost(postId);
		message.setStatus(StatusEnum.OK);
		message.setMessage(StringMessage.workComplete);
		message.setData(post);
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);
	}

	@PostMapping("/board/{boardId}/post/new")
	public ResponseEntity<Message> addPost(@PathVariable String boardId, @RequestBody Post paramPost) {
		Message message = new Message();
 		try {
			Post post = postService.findPost(paramPost.getPostId());
			String postId ="";
			if (!boardService.findBoard(boardId).isPresent()) {
				message.setStatus(StatusEnum.OK);
				message.setMessage(StringMessage.notExistBoard);
				message.setData(postId);
			} else {
				if (post.getPostId() ==null) {
					postId= postService.createPost(boardId, post);
				} else {
					postId= postService.updatePost(boardId, post);
				}
				message.setStatus(StatusEnum.OK);
				message.setMessage(StringMessage.workComplete);
				message.setData(postId);
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
			
			message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
			message.setMessage(StringMessage.workError);
		}
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);
	}
	@DeleteMapping("/board/{boardId}/post/{postId}")
	public ResponseEntity<Message> delPost(@PathVariable String boardId,@PathVariable String postId) {
		Message message = new Message();
		try {
			Optional<Board> board = boardService.findBoard(boardId);
			if(!board.isPresent()) 
			{
				message.setStatus(StatusEnum.OK);
				message.setMessage(StringMessage.notExistBoard);
				message.setData("");
				
			}else 
			{
				Post post = new Post();
				post.setPostId(postId);
				postService.deletePost(postId);
				message.setStatus(StatusEnum.OK);
				message.setMessage(StringMessage.workComplete);
				message.setData(postId);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			message.setStatus(StatusEnum.INTERNAL_SERVER_ERROR);
			message.setMessage(StringMessage.workError);
		}
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);

	}

}