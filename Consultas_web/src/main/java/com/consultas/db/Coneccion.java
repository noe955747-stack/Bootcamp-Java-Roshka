package com.consultas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el driver de PostgreSQL", e);
        }

        String url = "jdbc:postgresql://localhost:5432/bootcamp_market";
        String usuario = "postgres";
        String clave = "PIERRO2025";
        return DriverManager.getConnection(url, usuario, clave);
    }
}
