package com.ms.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import com.ms.user.services.UserService;

@SpringBootTest
@ActiveProfiles("test")
public class UserService2Test {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUserSucess() {
        var userModel = new UserModel();
        var userRecordDTO = new UserRecordDTO("Test", "Test@test.com");
        BeanUtils.copyProperties(userRecordDTO, userModel); // Faz a conversão de DTO para Model
        var userModel2 = new UserModel();
        var userRecordDTO2 = new UserRecordDTO("Test2", "Test2@test.com");
        BeanUtils.copyProperties(userRecordDTO2, userModel2);

        userService.save(userModel);
        userService.save(userModel2);

        int size = userRepository.findAll().size();

        Assertions.assertEquals(2, size);
        
    }
}
