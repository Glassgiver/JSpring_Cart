package glassgiver.springproject.services;

import glassgiver.springproject.model.Role;
import glassgiver.springproject.model.User;
import glassgiver.springproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.UserDefinedType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("User not found by id: " + s));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
