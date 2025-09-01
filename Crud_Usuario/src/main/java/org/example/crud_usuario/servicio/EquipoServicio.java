package org.example.crud_usuario.servicio;

import org.example.crud_usuario.modelo.Equipo;
import org.example.crud_usuario.repositorio.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServicio {

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    public List<Equipo> listarTodos() {
        return equipoRepositorio.findAll();
    }

    public Optional<Equipo> buscarPorId(Integer id) {
        return equipoRepositorio.findById(id);
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepositorio.save(equipo);
    }

    public void eliminar(Integer id) {
        equipoRepositorio.deleteById(id);
    }
}
