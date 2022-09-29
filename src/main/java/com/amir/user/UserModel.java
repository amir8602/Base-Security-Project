package com.amir.user;

import com.amir.book.BookEntity;
import com.amir.system.config.security.entity.Users;
import com.sun.istack.NotNull;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {


    private Long id;

    @NotEmpty(message = "NID not empty")
    private String username;

    @NotEmpty(message = "password not empty")
    private String password;

    private String firstName;

    private String lastName;

    private Long maxCount=3l;

    private Users users;

    private Set<BookEntity> bookEntitySet;

    public UserModel(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
