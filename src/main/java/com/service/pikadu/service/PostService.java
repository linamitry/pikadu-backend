package com.service.pikadu.service;

import com.service.pikadu.model.Post;
import com.service.pikadu.model.User;
import com.service.pikadu.repository.PostRepository;
import com.service.pikadu.request.PostRequest;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final SequenceGeneratorService sequenceGenerator;

    public Page<Post> getAllPosts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Post createPost(PostRequest request) {
        var post = Post.builder()
                .author(request.author)
                .comments(request.comments)
                .date(request.date)
                .like(request.like)
                .tags(request.tags)
                .text(request.text)
                .title(request.title)
                .id(sequenceGenerator.generateSequence(Post.SEQUENCE_NAME))
                .build();
        return repository.save(post);
    }
}
