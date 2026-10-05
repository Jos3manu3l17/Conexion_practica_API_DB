// Este archivo define la entidad Usuario que representa la tabla "usuarios" en la base de datos. Se utiliza la anotación @Entity para indicar que esta clase es una entidad JPA y @Table para especificar el nombre de la tabla correspondiente. La clase contiene atributos que representan las columnas de la tabla, junto con sus respectivos métodos getter y setter.

package com.ejemplo.conexiondb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "idUsuario")
    private Integer idUsuario;

    private String nombre;

    private String correo;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
