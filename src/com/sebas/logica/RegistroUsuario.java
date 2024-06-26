package com.sebas.logica;

import com.sebas.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

public class RegistroUsuario {
    private List<Usuario> usuarios;

    public RegistroUsuario() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean eliminarUsuario(String nombre) {
        return usuarios.removeIf(usuario -> usuario.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        List<Usuario> resultados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(usuario);
            }
        }
        return resultados;
    }
}
