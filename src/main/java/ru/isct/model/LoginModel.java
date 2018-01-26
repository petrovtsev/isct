package ru.isct.model;

import ru.isct.data.User;
import ru.isct.service.UserService;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class LoginModel {

    @Autowired
    private UserService userService;

    private User user;

    public boolean login(String login, String password) throws Exception {
        getUser(login);
        if (user != null && user.isConfirmed()) {
            return checkPassword(password);
        } else {
            return false;
        }
    }

    public User getUser(String login) {
        user = userService.findOne(login);
        return user;
    }

    public void registration(String login, String password) throws Exception {
        User user = new User();
        user.setLogin(login);
        user.setPassword(getHashSha256(password));
        user.setConfirmed(false);
        userService.save(user);
    }

    private boolean checkPassword(String password) {
        return user.getPassword().equals(getHashSha256(password));
    }

    private String getHashSha256(String str) {
        if (str != null) {
            return Hashing.sha256().hashString(str, StandardCharsets.UTF_8).toString();
        } else {
            return "";
        }
    }
}

