package com.service.pikadu.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class PostResponse {
    private long id;
    private String title;
    private String text;
    private ArrayList<String> tags;
    private Date date;
    private int likes;
    private int comments;
    private AuthorResponse author;
}
