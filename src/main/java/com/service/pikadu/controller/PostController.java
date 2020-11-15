package com.service.pikadu.controller;

import com.service.pikadu.exception.UserNotFoundException;
import com.service.pikadu.model.Post;
import com.service.pikadu.model.User;
import com.service.pikadu.request.LoginRequest;
import com.service.pikadu.request.PostRequest;
import com.service.pikadu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;
    @GetMapping()
    public Page<Post> get(Pageable request) {
        return service.getAllPosts(request);
    }
    @PostMapping()
    public Post create(PostRequest request) {
        return service.createPost(request);
    }
}
