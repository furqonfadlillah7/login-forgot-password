package com.furqonfadlilah.loginforgotpassword.repository;

import com.furqonfadlilah.loginforgotpassword.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
