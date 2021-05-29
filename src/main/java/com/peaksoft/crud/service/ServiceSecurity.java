package com.peaksoft.crud.service;
import com.peaksoft.crud.dao.UserDao;
import com.peaksoft.crud.model.Role;
import com.peaksoft.crud.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ServiceSecurity implements UserDetailsService {

    private final UserDao userDao;

    public ServiceSecurity(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDao.findByUsername(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantedAuthorities);
    }


//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userService.findByUsername(s);
//        if (user == null) {
//            throw new UsernameNotFoundException("Unknown user: "+ s);
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));
//    }
//
//    private Set<? extends GrantedAuthority>mapRolesToAuthorities(Set<Role>roles) {
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toSet());
//    }
}
