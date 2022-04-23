package com.furqonfadlilah.loginforgotpassword.service.framework;

import com.furqonfadlilah.loginforgotpassword.entity.Mail;

public interface EmailService {
    void send(Mail mail);
}
