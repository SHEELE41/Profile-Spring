package com.mevius.profile.service;

import com.mevius.profile.domain.user.User;
import com.mevius.profile.domain.user.UserRepository;
import com.mevius.profile.web.dto.ProfileUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final UserRepository userRepository;

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public Long update(Long id, ProfileUpdateRequestDto requestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        user.update(requestDto.getBio(), requestDto.getGithub(), requestDto.getWebsite());
        return id;
    }
}
