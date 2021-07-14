package com.mevius.profile.domain;

import com.mevius.profile.domain.user.Role;
import com.mevius.profile.domain.user.User;
import com.mevius.profile.domain.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void saveAndFindUser() {
        String name = "석종규";
        String email = "mevius1718@gmail.com";

        userRepository.save(User.builder()
                .name(name)
                .email(email)
                .picture(null)
                .role(Role.USER)
                .build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
