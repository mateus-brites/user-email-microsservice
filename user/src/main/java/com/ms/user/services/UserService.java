package com.ms.user.services;

import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional //garantindo que nenhuma informação seja persistida se todo o processo não tiver 100% de êxito.
    public UserModel save(UserModel userModel) {
        userProducer.publishMessageEmail(userModel);
        return userRepository.save(userModel);
    }
}
