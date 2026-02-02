package es.transportesamartin.service;

import es.transportesamartin.domain.Usuario;
import es.transportesamartin.repository.UsuarioSpringRepository;
import es.transportesamartin.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsuarioSpringRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public Map<String,Object> register(String username, String password, String email){
        return register(username,password,email, Usuario.Rol.TRANSPORTISTA);
    }

    public Map<String, Object> register(String username, String password, String email, Usuario.Rol rol) {
        if (userRepo.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepo.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        Usuario usuario = new Usuario(username, passwordEncoder.encode(password), email, rol);
        usuario = userRepo.save(usuario);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtTokenProvider.generateToken(userDetails);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", usuario.getNombre());
        response.put("email", usuario.getEmail());
        response.put("message", "Usuario registrado correctamente");

        return response;
    }

    public Map<String, Object> login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtTokenProvider.generateToken(userDetails);

        Usuario user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("username", user.getNombre());
        response.put("email", user.getEmail());
        response.put("message", "Inicio de sesión exitoso");

        return response;
    }
}
