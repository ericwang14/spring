package com.apress.pss.terrormovies.model;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created ${name}
 *
 * @author wanggang
 * @since ${Date}
 */
public class User extends org.springframework.security.core.userdetails.User {

    private String lastName;
    private int age;
    /**
     * Calls the more complex constructor with all boolean arguments set to {@code true}.
     *
     * @param username
     * @param password
     * @param authorities
     */
    public User(String username, String password, Collection<? extends GrantedAuthority> authorities, String lastName, int age) {
        super(username, password, authorities);
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Construct the <code>User</code> with the details required by
     * {@link DaoAuthenticationProvider}.
     *
     * @param username              the username presented to the
     *                              <code>DaoAuthenticationProvider</code>
     * @param password              the password that should be presented to the
     *                              <code>DaoAuthenticationProvider</code>
     * @param enabled               set to <code>true</code> if the user is enabled
     * @param accountNonExpired     set to <code>true</code> if the account has not
     *                              expired
     * @param credentialsNonExpired set to <code>true</code> if the credentials
     *                              have not expired
     * @param accountNonLocked      set to <code>true</code> if the account is not
     *                              locked
     * @param authorities           the authorities that should be granted to the caller
     *                              if they presented the correct username and password and the user
     *                              is enabled. Not null.
     * @throws IllegalArgumentException if a <code>null</code> value was passed
     *                                  either as a parameter or as an element in the
     *                                  <code>GrantedAuthority</code> collection
     */
    public User(String username, String password, boolean enabled, boolean accountNonExpired,
                boolean credentialsNonExpired, boolean accountNonLocked,
                Collection<? extends GrantedAuthority> authorities, String lastName, int age) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
