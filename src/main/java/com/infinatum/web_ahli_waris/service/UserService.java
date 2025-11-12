package com.infinatum.web_ahli_waris.service;

public interface UserService {
    public boolean login(String username, String password);
    public boolean changePass(String username, String oldPassword, String newPassword);
}
