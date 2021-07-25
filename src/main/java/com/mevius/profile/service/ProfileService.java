package com.mevius.profile.service;

import com.mevius.profile.domain.user.User;
import com.mevius.profile.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final UserRepository userRepository;

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
