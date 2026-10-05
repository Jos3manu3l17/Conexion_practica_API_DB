// Este archivo define el repositorio de usuarios que extiende JpaRepository para proporcionar operaciones CRUD y consultas personalizadas en la entidad Usuario. La interfaz UsuarioRepository permite interactuar con la base de datos a través de métodos predefinidos y consultas derivadas.

package com.ejemplo.conexiondb.repository;

import com.ejemplo.conexiondb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
