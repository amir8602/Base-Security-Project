package com.amir.user;


import com.amir.book.BookEntity;
import com.amir.system.config.security.entity.Users;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Long maxCount = 3l;

    //    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;


    @ManyToMany(mappedBy = "userEntitySet")
    private Set<BookEntity> bookEntitySet;


}
