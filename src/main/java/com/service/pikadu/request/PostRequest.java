package com.service.pikadu.request;

import com.service.pikadu.model.Author;
import com.service.pikadu.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
public class PostRequest {
    public String title;
    public String text;
    public ArrayList<String> tags;
    public Date date;
    public int like;
    public int comments;
    public Author author;
}
