package com.service.pikadu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "posts")
@Data
@Builder
public class Post {
    @Transient
    public static final String SEQUENCE_NAME = "posts_sequence";
    @JsonIgnore
    @Id
    public long id;
    public String title;
    public String text;
    public ArrayList<String> tags;
    public Date date;
    public int like;
    public int comments;
    public Author author;
}
