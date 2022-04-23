package com.furqonfadlilah.loginforgotpassword.service.framework;

import com.furqonfadlilah.loginforgotpassword.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}
