package com.service.pikadu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;
    @ApiModelProperty(hidden = true)
    @OneToMany(mappedBy = "author")
    private Collection<Post> posts;
    @Column(name = "email", unique = true)
    private String email;
    private String password;
    private String displayName;
    private String photo;

    public User(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, email='%s']",
                id, email);
    }
}
