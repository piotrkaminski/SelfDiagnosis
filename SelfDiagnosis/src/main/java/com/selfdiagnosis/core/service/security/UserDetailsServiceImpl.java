package com.selfdiagnosis.core.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.dao.SystemUserDAO;
import com.selfdiagnosis.core.entity.SecurityRoleEntity;
import com.selfdiagnosis.core.entity.SystemUserEntity;

/**
 * Implementation of {@link UserDetailsService} to adjust taking users from local database.
 * Important! There is assumption that email is used as user name.
 * 
 * @author pkaminski
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SystemUserDAO dao;

    /**
     * Loads user from database using email as a username. Result is used
     * to create {@link User} object used by SpringSecurity framework
     * to perform authentication and authorization.
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        SystemUserEntity userEntity = dao.findByEmail(username);
        if (userEntity == null)
            throw new UsernameNotFoundException("user not found");
        return buildUserFromUserEntity(userEntity);
    }

    protected User buildUserFromUserEntity(SystemUserEntity userEntity) {
        String username = userEntity.getEmail();
        String password = userEntity.getPassword();
        boolean enabled = userEntity.getEnabled();
        boolean accountNonExpired = userEntity.getEnabled();
        boolean credentialsNonExpired = userEntity.getEnabled();
        boolean accountNonLocked = userEntity.getEnabled();
        
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (SecurityRoleEntity role : userEntity.getSecurityRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        User user = new User(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
        return user;
    }

}
