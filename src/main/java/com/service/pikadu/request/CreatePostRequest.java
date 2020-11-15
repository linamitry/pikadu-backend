package com.service.pikadu.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class CreatePostRequest {
    private String title;
    private String text;
    private ArrayList<String> tags;
    private Date date;
    private int likes;
    private int comments;
    private Author author;

    @Data
    class Author {
        private long id;
    }
}
