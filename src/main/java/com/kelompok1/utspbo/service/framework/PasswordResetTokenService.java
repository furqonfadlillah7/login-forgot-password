package com.kelompok1.utspbo.service.framework;

import com.kelompok1.utspbo.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}
