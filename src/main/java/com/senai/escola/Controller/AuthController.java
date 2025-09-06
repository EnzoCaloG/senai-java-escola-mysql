package com.senai.escola.Controller;


import com.senai.escola.Models.Usuario;

import com.senai.escola.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario){

        Usuario user = usuarioService.fazerLogin(usuario.getUsername(), usuario.getSenha());
        if(user!=null){
            return "O login deu certo!!!" + user.getUsername();
        }
        return "Usuario não existe";
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario){
        return usuarioService.salvarUser(usuario);
    }

}
