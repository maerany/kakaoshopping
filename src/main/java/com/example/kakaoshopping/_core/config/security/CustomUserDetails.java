package com.example.kakaoshopping._core.config.security;

import com.example.kakaoshopping.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/*  @RequiredArgsConstructor
    해당 어노테이션으로 생성자가 자동으로 생성되며,
    CustomUserDetails 객체가 생성될 때 클래스 생성자에 의해서 User 객체가 주입된다.
    이러한 주입은 Spring의 의존성 주입(DI)기능을 통해 이뤄짐.
    @RequiredArgsConstructor은 final 필드나 @NonNull 어노테이션이 붙은 필드를 가지고 생성자를 생성해줌
 */
@RequiredArgsConstructor
@Getter
public class CustomUserDetails implements UserDetails {
// UserDetails 인터페이스를 구현한 CustomUserDetails는
// Security에서 사용자의 정보를 담는 VO의 개념
// UserDetails를 구현함으로써 Security 인가, 인증 관련 작업 시
// 해당 인터페이스를 기준으로 작업 진행

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
