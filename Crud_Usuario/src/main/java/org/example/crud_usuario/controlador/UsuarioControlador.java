package org.example.crud_usuario.controlador;

import org.example.crud_usuario.modelo.Usuario;
import org.example.crud_usuario.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioServicio.listarTodos();
    }
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioServicio.guardarUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Integer id) {
        return usuarioServicio.buscarUsuarioPorID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipo/{idEquipo}")
    public List<Usuario> listarPorEquipo(@PathVariable Integer idEquipo) {
        return usuarioServicio.buscarPorEquipo(idEquipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario datos) {
        return usuarioServicio.buscarUsuarioPorID(id).map(usuario -> {
            usuario.setNombre(datos.getNombre());
            usuario.setApellido(datos.getApellido());
            usuario.setNroCedula(datos.getNroCedula());
            usuario.setCorreo(datos.getCorreo());
            usuario.setId_rol(datos.getId_rol());
            usuario.setFechaIngreso(datos.getFechaIngreso());
            usuario.setAntiguedad(datos.getAntiguedad());
            usuario.setDias_vacaciones(datos.getDias_vacaciones());
            usuario.setEstado(datos.getEstado());
            usuario.setContrasena(datos.getContrasena());
            usuario.setTelefono(datos.getTelefono());
            usuario.setIdEquipo(datos.getIdEquipo());
            usuario.setId_cargo(datos.getId_cargo());
            usuario.setFechaNacimiento(datos.getFechaNacimiento());
            usuario.setDiasVacacionesRestantes(datos.getDiasVacacionesRestantes());
            usuario.setRequiereCambioContrasena(datos.getRequiereCambioContrasena());
            return ResponseEntity.ok(usuarioServicio.guardarUsuario(usuario));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (usuarioServicio.buscarUsuarioPorID(id).isPresent()) {
            usuarioServicio.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
