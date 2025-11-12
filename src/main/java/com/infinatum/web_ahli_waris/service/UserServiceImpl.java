package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.User;
import com.infinatum.web_ahli_waris.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean login(String username, String password) {
        User user = userRepo.findByUsername(username).orElse(null);
        if (user == null) return false;
        return passwordEncoder.matches(password, user.getPassword());
    }

    public boolean changePass(String username, String oldPassword, String newPassword) {
        User user = userRepo.findByUsername(username).orElse(null);
        if (user == null) return false;

        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
