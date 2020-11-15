package com.service.pikadu.service;

import com.service.pikadu.model.Post;
import com.service.pikadu.repository.PostRepository;
import com.service.pikadu.request.CreatePostRequest;
import com.service.pikadu.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    private final ModelMapper mapper;

    public Page<PostResponse> getAllPosts(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        var result = postRepository.findAll(paging);
        return result.map(this::convertToDto);
    }

    public Post createPost(CreatePostRequest post) {
        return postRepository.save(convertToEntity(post));
    }

    private PostResponse convertToDto(Post entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, PostResponse.class);
    }

    private Post convertToEntity(CreatePostRequest postDto) {
        System.out.println(mapper.map(postDto, Post.class));
        return mapper.map(postDto, Post.class);
    }
}
