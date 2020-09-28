package com.nubnasir.newsstories.user.service;

import com.nubnasir.newsstories.authentication.encryption.ApplicationUserAuthentication;
import com.nubnasir.newsstories.user.model.dto.UserRegistrationDto;
import com.nubnasir.newsstories.user.model.entity.UserEntity;
import com.nubnasir.newsstories.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserRegistrationDto registrationDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(registrationDto.getUserName());
        userEntity.setFullName(registrationDto.getFullName());
        userEntity.setPassword(ApplicationUserAuthentication.encrypt(registrationDto.getPassword()));
        userEntity.setRegistrationDate(new Date());

        userRepository.create(userEntity);
    }

    public UserEntity getByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }

    public boolean isAuthenticate(String userName, String password){

        UserEntity userEntity = userRepository.getByUserName(userName);
        if(userEntity != null && ApplicationUserAuthentication.match(password, userEntity.getPassword())) {
            userEntity.setLastLogInDate(new Date());
            userRepository.update(userEntity);
            return true;
        }
        return false;
    }

}
