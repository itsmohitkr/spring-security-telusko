package online.devplanet.spring_security_demo.service;

import online.devplanet.spring_security_demo.Repo.UserRepo;
import online.devplanet.spring_security_demo.model.User;
import online.devplanet.spring_security_demo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= userRepo.findByUsername(username);
       if(user==null){
           System.out.println("User not found");
           throw new UsernameNotFoundException("User not found");
       }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        return new UserPrincipal(user.getUserId(),user.getUsername(),user.getPassword(),authorities);

    }

    public UserDetails loadUserByUserId(String userId) {
        User user = userRepo.findByUserId(UUID.fromString(userId));
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        return new UserPrincipal(user.getUserId(),user.getUsername(),user.getPassword(),authorities);
    }
}
