package com.amir.system.config.security.entity;

import com.amir.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private boolean enabled;

    //	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn( name = "user_id",referencedColumnName = "id" )
    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private UserEntity user;

}
