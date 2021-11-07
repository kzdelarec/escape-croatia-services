package hr.tvz.zdelarec.escapecroatioaservices.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Security utility class.
 *
 * @author kristijan.zdelarec
 */
public final class SecurityUtils {

    private SecurityUtils() { }

    /**
     * Method for extracting username of a logged in user.
     * @return username
     */
    public static String getUsername() {
        final User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

    /**
     * Method for extracting authorities of a logged in user.
     * @return authorities
     */
    public static Collection<GrantedAuthority> getAuthority() {
        final User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getAuthorities();
    }

}
