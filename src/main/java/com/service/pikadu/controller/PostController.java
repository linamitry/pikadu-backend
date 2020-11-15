package com.service.pikadu.controller;

import com.service.pikadu.model.Post;
import com.service.pikadu.request.CreatePostRequest;
import com.service.pikadu.response.PostResponse;
import com.service.pikadu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;
    @GetMapping()
    public Page<PostResponse> get(@RequestParam(defaultValue = "0") Integer pageNo,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return service.getAllPosts(pageNo, pageSize, sortBy);
    }
    @PostMapping()
    public Post create(@RequestBody CreatePostRequest request) {
        return service.createPost(request);
    }
}
