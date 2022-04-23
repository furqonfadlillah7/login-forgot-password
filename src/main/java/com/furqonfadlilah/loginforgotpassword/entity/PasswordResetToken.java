package com.furqonfadlilah.loginforgotpassword.entity;

import lombok.Cleanup;
import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_password_reset_token")
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String token;
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User user;
    @Column(nullable = false)
    private LocalDateTime expirationDate;

}
