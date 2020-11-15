package com.service.pikadu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document(collection = "users")
@Data
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @JsonIgnore
    @Id
    public long id;

    public String email;
    public String password;
    public String displayName;


    public User() {
    }

    public User(String email, String password, String displayName) {
        this.email = email;
        this.password = password;
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s']",
                id, email);
    }
}
