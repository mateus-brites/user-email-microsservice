package com.ms.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import com.ms.user.services.UserService;

@ActiveProfiles
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Autowired
    @InjectMocks // Injeta as dependências mocadas no lugar das reais
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // Inicia os Mocks
    }
    
    @Test
    @DisplayName("Shoulde create a user with sucess")
    void CreateUserCase1() {
        var userModel = new UserModel();
        var userRecordDTO = new UserRecordDTO("Test", "Test@test.com");
        BeanUtils.copyProperties(userRecordDTO, userModel); // Faz a conversão de DTO para Model
        userService.save(userModel);

        verify(userRepository, times(1)).save(any());
    }
}
