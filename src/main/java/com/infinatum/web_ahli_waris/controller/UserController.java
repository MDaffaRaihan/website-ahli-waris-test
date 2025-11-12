package com.infinatum.web_ahli_waris.controller;

import com.infinatum.web_ahli_waris.models.User;
import com.infinatum.web_ahli_waris.repository.UserRepo;
import com.infinatum.web_ahli_waris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        boolean success = userService.login(username, password);
        return success ? "Login success" : "Invalid credentials";
    }

    @PostMapping("/change-pass")
    public String changePass(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String oldPassword = body.get("oldPassword");
        String newPassword = body.get("newPassword");

        boolean success = userService.changePass(username, oldPassword, newPassword);
        return success ? "Password successfully change": "Please check your old password";
    }
}
