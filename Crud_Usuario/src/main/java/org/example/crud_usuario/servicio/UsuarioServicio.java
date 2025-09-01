package org.example.crud_usuario.servicio;

import org.example.crud_usuario.modelo.Usuario;
import org.example.crud_usuario.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodos(){
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario>buscarUsuarioPorID(Integer id){
        return usuarioRepositorio.findById(id);
    }

    public List<Usuario> buscarPorEquipo(Integer idEquipo) {
        return usuarioRepositorio.findByIdEquipo(idEquipo);
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Integer id){
        usuarioRepositorio.deleteById(id);
    }
}
