//package com.senai.ApiManeasy.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.UUID;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "tb_usuarios")
//public class UsuarioModel implements Serializable, UserDetails {
//
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_usuario", nullable = false)
//    private UUID id;
//
//    private String nome_usuario;
//    private String chapa_usuario;
//    private String email;
//    private String senha;
//    private String tipo;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return senha;
//    }
//
//    @Override
//    public String getUsername() {
//        return nome_usuario;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}