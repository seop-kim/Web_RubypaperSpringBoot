package com.rubypaper.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Collection;

@Getter
@Setter
@ToString
@Entity
public class Member {

    @Id
    private String id;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean enabled;


}
