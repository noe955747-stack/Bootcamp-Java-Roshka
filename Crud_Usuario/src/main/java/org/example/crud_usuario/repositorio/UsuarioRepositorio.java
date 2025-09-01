package org.example.crud_usuario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.crud_usuario.modelo.Usuario;
import java.util.List;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByIdEquipo(Integer idEquipo);
}