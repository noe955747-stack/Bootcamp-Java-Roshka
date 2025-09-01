package org.example.crud_usuario.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_Usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nro_cedula")
    private Integer nroCedula;

    @Column(name = "correo")
    private String correo;

    @Column(name = "id_rol")
    private Integer id_rol;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "antiguedad")
    private String antiguedad;

    @Column(name="dias_vacaciones")
    private Integer dias_vacaciones;

    @Column(name="estado")
    private Boolean estado;

    @Column(name="contrasena")
    private String contrasena;

    @Column(name = "telefono")
    private String telefono;

    @Column(name="id_equipo")
    private Integer idEquipo;

    @ManyToOne
    @JoinColumn(name = "id_equipo", insertable = false, updatable = false)
    private Equipo equipo;

    @Column(name="id_cargo")
    private Integer id_cargo;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "dias_vacaciones_restante")
    private Integer diasVacacionesRestantes;

    @Column(name = "requiere_cambio_contrasena")
    private Boolean requiereCambioContrasena;

    public Usuario() {}

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(Integer nroCedula) {
        this.nroCedula = nroCedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getDias_vacaciones() {
        return dias_vacaciones;
    }

    public void setDias_vacaciones(Integer dias_vacaciones) {
        this.dias_vacaciones = dias_vacaciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getDiasVacacionesRestantes() {
        return diasVacacionesRestantes;
    }

    public void setDiasVacacionesRestantes(Integer diasVacacionesRestantes) {
        this.diasVacacionesRestantes = diasVacacionesRestantes;
    }


    public Boolean getRequiereCambioContrasena() {
        return requiereCambioContrasena;
    }

    public void setRequiereCambioContrasena(Boolean requiereCambioContrasena) {
        this.requiereCambioContrasena = requiereCambioContrasena;
    }

}
