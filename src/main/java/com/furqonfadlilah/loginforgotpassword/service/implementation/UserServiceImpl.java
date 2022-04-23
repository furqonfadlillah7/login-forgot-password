package com.furqonfadlilah.loginforgotpassword.service.implementation;

import com.furqonfadlilah.loginforgotpassword.entity.Role;
import com.furqonfadlilah.loginforgotpassword.entity.User;
import com.furqonfadlilah.loginforgotpassword.repository.RoleRepository;
import com.furqonfadlilah.loginforgotpassword.repository.UserRepository;
import com.furqonfadlilah.loginforgotpassword.service.framework.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                           RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email Not Found!"));
        new AccountStatusUserDetailsChecker().check(user);
        return user;
    }

    @Override
    @Modifying
    public void updatePassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findById(1L).orElse(null);
        if(role != null){
            user.setRoles(new HashSet<>(Collections.singletonList(role)));
            return userRepository.save(user);
        }
        userRepository.save(user);
        return user;
    }
}
