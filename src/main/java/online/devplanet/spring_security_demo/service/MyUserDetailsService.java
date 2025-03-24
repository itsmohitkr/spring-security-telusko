package online.devplanet.spring_security_demo.service;

import online.devplanet.spring_security_demo.Repo.UserRepo;
import online.devplanet.spring_security_demo.model.User;
import online.devplanet.spring_security_demo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
         return new UserPrincipal(user);

    }
}
