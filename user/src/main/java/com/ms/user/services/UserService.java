package com.ms.user.services;

import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional //garantindo que nenhuma informação seja persistida se todo o processo não tiver 100% de êxito.
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }
}
