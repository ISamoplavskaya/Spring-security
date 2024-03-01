package com.example.spring_security.controller;

import com.example.spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/user")
    public String userEndpoint() {
        return "Це ендпоінт для зареєстрованих користувачів.";
    }

    @GetMapping("/userAdmin")
    public String adminEndpoint() {
        return "Це ендпоінт для адміністраторів.";
    }

    @GetMapping("/userVip")
    public String vipEndpoint() {
        return "Це ендпоінт для користувачів з роллю VIP.";
    }

    @GetMapping("/userPremium")
    @PreAuthorize("hasAuthority('PREMIUM')")
    public String premiumEndpoint() {
        return "Це ендпоінт для користувачів з роллю PREMIUM.";
    }

}
