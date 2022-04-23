package com.furqonfadlilah.loginforgotpassword.service.implementation;

import com.furqonfadlilah.loginforgotpassword.entity.PasswordResetToken;
import com.furqonfadlilah.loginforgotpassword.repository.PasswordResetTokenRepository;
import com.furqonfadlilah.loginforgotpassword.service.framework.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository){
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    @Override
    public PasswordResetToken findByToken(String token){
        return passwordResetTokenRepository.findByToken(token).orElse(null);
    }

    @Override
    public PasswordResetToken save(PasswordResetToken passwordResetToken){
        return  passwordResetTokenRepository.save(PasswordResetToken);
    }
}
