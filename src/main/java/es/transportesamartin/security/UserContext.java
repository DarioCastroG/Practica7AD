package es.transportesamartin.security;

import es.transportesamartin.domain.Usuario;
import es.transportesamartin.repository.UsuarioSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserContext {

    @Autowired
    private UsuarioSpringRepository userRepo;

    public Long getCurrentUserId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth==null || !auth.isAuthenticated()){
            throw new IllegalStateException("El usuario no esta registrado");
        }

        Object principal = auth.getPrincipal();

        String username = ((UserDetails) principal).getUsername();

        Usuario user = userRepo.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("Usuario no encontrado: " + username));

        return user.getId();
    }
}
