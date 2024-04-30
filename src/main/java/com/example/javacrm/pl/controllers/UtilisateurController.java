package com.example.javacrm.pl.controllers;

import com.example.javacrm.bll.services.UtilisateurService;
import com.example.javacrm.pl.models.AuthDTO;
import com.example.javacrm.pl.models.LoginForm;
import com.example.javacrm.pl.models.RegisterForm;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form){
        return utilisateurService.login(form);
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public void register(@RequestBody RegisterForm form){
        utilisateurService.register(form);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public Set<String> getAllNames(){
        return utilisateurService.getAllName();
    }
}
