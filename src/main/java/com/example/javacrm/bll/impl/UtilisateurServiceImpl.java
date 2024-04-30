package com.example.javacrm.bll.impl;

import com.example.javacrm.bll.services.UtilisateurService;
import com.example.javacrm.dal.entities.Utilisateur;
import com.example.javacrm.dal.repositories.UtilisateurRepository;
import com.example.javacrm.pl.config.security.JWTProvider;
import com.example.javacrm.pl.models.AuthDTO;
import com.example.javacrm.pl.models.LoginForm;
import com.example.javacrm.pl.models.RegisterForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager, JWTProvider jwtProvider, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterForm form) {
        if(form == null)
            throw new IllegalArgumentException("form peut pas être null");

        Utilisateur entity = new Utilisateur();
        entity.setUsername(form.username());
        entity.setPassword(passwordEncoder.encode(form.password()));
        entity.setRole(form.role());

        Utilisateur savedUtilisateur = utilisateurRepository.save(entity);

        savedUtilisateur.setReference("U-" + savedUtilisateur.getId());

        utilisateurRepository.save(savedUtilisateur);
    }

    @Override
    public AuthDTO login(LoginForm form) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.username(),form.password()));

        Utilisateur user = utilisateurRepository.findByUsername(form.username()).orElseThrow(() -> new EntityNotFoundException("Username not found"));

        String token = jwtProvider.generateToken(user.getUsername(), List.of(user.getRole()));

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }


    @Override
    public Optional<Utilisateur> getOne(String login) {
        return utilisateurRepository.findByUsername(login);
    }

    @Override
    public Set<String> getAllName() {
        return utilisateurRepository.findAll().stream().map(Utilisateur::getUsername).collect(Collectors.toSet());
    }

}
