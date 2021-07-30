package com.mevius.profile.web;

import com.mevius.profile.service.ProfileService;
import com.mevius.profile.web.dto.ProfileUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProfileApiController {
    private final ProfileService profileService;

    @PutMapping("/api/v1/profile/{uid}")
    public Long update(@RequestBody ProfileUpdateRequestDto profileUpdateRequestDto, @PathVariable String uid) {
        return profileService.update(Long.parseLong(uid), profileUpdateRequestDto);
    }
}
