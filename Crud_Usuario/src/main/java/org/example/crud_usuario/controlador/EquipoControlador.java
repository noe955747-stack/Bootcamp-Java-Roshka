package org.example.crud_usuario.controlador;

import org.example.crud_usuario.modelo.Equipo;
import org.example.crud_usuario.servicio.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoControlador {

    @Autowired
    private EquipoServicio equipoServicio;

    @GetMapping
    public List<Equipo> listar() {
        return equipoServicio.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtener(@PathVariable Integer id) {
        return equipoServicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> crear(@RequestBody Equipo equipo) {
        return ResponseEntity.status(201).body(equipoServicio.guardar(equipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Integer id, @RequestBody Equipo datos) {
        return equipoServicio.buscarPorId(id).map(equipo -> {
            equipo.setNombre(datos.getNombre());
            return ResponseEntity.ok(equipoServicio.guardar(equipo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (equipoServicio.buscarPorId(id).isPresent()) {
            equipoServicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}