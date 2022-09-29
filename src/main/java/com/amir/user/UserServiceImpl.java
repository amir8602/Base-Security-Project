package com.amir.user;

import com.amir.system.config.security.entity.Authorities;
import com.amir.system.config.security.entity.Users;
import com.amir.system.config.security.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Override
    public UserModel registerUser(UserModel userFromController) {

        Authorities authorities = new Authorities();
        authorities.setUsername(userFromController.getUsername());
        authorities.setAuthorityType("ROLE_USER");
        authoritiesRepository.save(authorities);

        UserEntity modelConvertedToEntity =new UserEntity();

        Users attacheUsers = new Users();
        attacheUsers.setUsername(userFromController.getUsername());
        attacheUsers.setPassword(passwordEncoder.encode(userFromController.getPassword()));
        attacheUsers.setEnabled(true);


        modelConvertedToEntity.setFirstName(userFromController.getFirstName());
        modelConvertedToEntity.setLastName(userFromController.getLastName());
        modelConvertedToEntity.setPassword(passwordEncoder.encode(userFromController.getPassword()));
        modelConvertedToEntity.setUsername(userFromController.getUsername());
        modelConvertedToEntity.setUsers(attacheUsers);

        UserEntity savedToDatabaseEntity = userRepository.save(modelConvertedToEntity);

        UserModel entityConvertedToModel = new UserModel();
        entityConvertedToModel.setId(savedToDatabaseEntity.getId());
        entityConvertedToModel.setFirstName(entityConvertedToModel.getFirstName());
        entityConvertedToModel.setLastName(entityConvertedToModel.getLastName());
        entityConvertedToModel.setUsername(entityConvertedToModel.getUsername());
        entityConvertedToModel.setPassword(entityConvertedToModel.getPassword());

        return entityConvertedToModel;
    }
}
