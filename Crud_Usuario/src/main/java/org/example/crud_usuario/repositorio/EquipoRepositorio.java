package org.example.crud_usuario.repositorio;

import org.example.crud_usuario.modelo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Integer> {
}