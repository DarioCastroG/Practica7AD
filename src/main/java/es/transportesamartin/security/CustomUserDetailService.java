package es.transportesamartin.security;

import es.transportesamartin.domain.Usuario;
import es.transportesamartin.repository.UsuarioSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UsuarioSpringRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario user = userRepo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(("Usuario no encontrado: "+username)));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getNombre())
                .password(user.getContrasena())
                .authorities(getAuthorities(user))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!user.isEnabled())
                .build();

    }

    private Collection<? extends GrantedAuthority> getAuthorities(Usuario user) {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name())).
                collect(Collectors.toList());
    }
}
