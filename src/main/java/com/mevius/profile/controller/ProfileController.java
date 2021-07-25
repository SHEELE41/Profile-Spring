package com.mevius.profile.controller;

import com.mevius.profile.config.auth.dto.SessionUser;
import com.mevius.profile.domain.user.User;
import com.mevius.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class ProfileController {
    private final HttpSession httpSession;
    private final ProfileService profileService;

    @RequestMapping(value = "/profile/{uid}")
    public String Profile(Model model, @PathVariable String uid) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if (sessionUser != null) {
            model.addAttribute("sessionUserName", sessionUser.getName());
            model.addAttribute("sessionUserEmail", sessionUser.getEmail());
        }
        if (profileService.findOne(Long.parseLong(uid)).isPresent()) {
            User user = profileService.findOne(Long.parseLong(uid)).get();
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPicture", user.getPicture());
            model.addAttribute("userBio", user.getBio());
            model.addAttribute("userGithub", user.getGithub());
            model.addAttribute("userWebsite", user.getWebsite());
            model.addAttribute("userId", user.getId());
        }

        return "page/profile";
    }

    @GetMapping("/profile/update/{uid}")
    public String EditProfile(Model model, @PathVariable String uid) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        if (sessionUser != null) {
            model.addAttribute("sessionUserName", sessionUser.getName());
            model.addAttribute("sessionUserEmail", sessionUser.getEmail());
        }
        if (profileService.findOne(Long.parseLong(uid)).isPresent()) {
            User user = profileService.findOne(Long.parseLong(uid)).get();
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPicture", user.getPicture());
            model.addAttribute("userBio", user.getBio());
            model.addAttribute("userGithub", user.getGithub());
            model.addAttribute("userWebsite", user.getWebsite());
            model.addAttribute("userId", user.getId());
        }

        return "page/profile_edit";
    }
}
