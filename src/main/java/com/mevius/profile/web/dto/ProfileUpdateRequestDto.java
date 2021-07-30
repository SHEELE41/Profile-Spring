package com.mevius.profile.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileUpdateRequestDto {
    private String github;
    private String bio;
    private String website;

    @Builder
    public ProfileUpdateRequestDto(String github, String bio, String website) {
        this.github = github;
        this.bio = bio;
        this.website = website;
    }
}
