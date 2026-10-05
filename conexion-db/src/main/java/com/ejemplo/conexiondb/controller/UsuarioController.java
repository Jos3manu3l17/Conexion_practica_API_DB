// Este archivo define el controlador REST para manejar las solicitudes relacionadas con los usuarios. Se utiliza la anotación @RestController para indicar que esta clase es un controlador REST y @RequestMapping para definir la ruta base "/usuarios". Además, se permite el acceso desde el origen "http://

package com.ejemplo.conexiondb.controller;

import com.ejemplo.conexiondb.model.Usuario;
import com.ejemplo.conexiondb.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }
}
