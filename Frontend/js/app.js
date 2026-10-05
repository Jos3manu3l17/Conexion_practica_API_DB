// Obtener referencias a los elementos del DOM
const btnCargar = document.getElementById("btnCargar");
// Obtener referencia al contenedor donde se mostrarán los usuarios
const listaUsuarios = document.getElementById("listaUsuarios");
// Agregar un evento al botón para cargar los usuarios cuando se haga clic
btnCargar.addEventListener("click", obtenerUsuarios);

async function obtenerUsuarios() {

    const respuesta = await fetch("http://localhost:8080/usuarios");

    const usuarios = await respuesta.json();

    mostrarUsuarios(usuarios);
}

function mostrarUsuarios(usuarios) {
// Limpiar la lista de usuarios antes de mostrar los nuevos datos
    listaUsuarios.innerHTML = "";
// Iterar sobre cada usuario y crear una tarjeta para mostrar su información
    usuarios.forEach(usuario => {

        const tarjeta = document.createElement("div");

        tarjeta.classList.add("usuario");
        // Agregar el contenido de la tarjeta con la información del usuario
        tarjeta.innerHTML = `
            <h3>${usuario.nombre}</h3>
            <p>ID: ${usuario.idUsuario}</p>
            <p>Correo: ${usuario.correo}</p>
        `;
        // Agregar la tarjeta al contenedor de usuarios
        listaUsuarios.appendChild(tarjeta);
    });
}
