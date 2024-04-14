package ndgroups.mbrailway.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails{
    private User user;
    public CustomUserDetails(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
//        return authorities;
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (user.getRole() == null) {
//            // Default to ROLE_USER if user role is null
//            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        } else {
//            // Split the roles string by comma and create GrantedAuthority objects
//            String[] roles = user.getRole().split(",");
//            for (String role : roles) {
//                authorities.add(new SimpleGrantedAuthority(role.trim()));
//            }
//        }
//
//        return authorities;
//
//    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
