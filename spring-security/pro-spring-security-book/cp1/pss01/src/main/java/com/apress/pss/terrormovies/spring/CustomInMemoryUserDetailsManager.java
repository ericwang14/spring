package com.apress.pss.terrormovies.spring;

import com.apress.pss.terrormovies.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
public class CustomInMemoryUserDetailsManager implements UserDetailsService {

    Map<String, User> users = new HashMap<>();

    public CustomInMemoryUserDetailsManager(Collection<User> users) {
        for (User user : users) {
            this.users.put(user.getUsername(), user);
        }
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search may possibly be case
     * insensitive, or case insensitive depending on how the implementation instance is configured. In this case, the
     * <code>UserDetails</code> object that comes back may have a username that is of a different case than what was
     * actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no GrantedAuthority
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.get(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        User userNew = new User(user.getUsername(), user.getPassword(), user.getAuthorities(), user.getLastName(), user.getAge());
        return userNew;
    }
}
