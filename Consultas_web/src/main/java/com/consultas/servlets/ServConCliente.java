package com.consultas.servlets;

import com.consultas.db.Coneccion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ServConCliente")
public class ServConCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.resetBuffer();

        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html lang='es'>");
        out.print("<head>");
        out.print("  <meta charset='UTF-8'>");
        out.print("  <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("  <title>Consulta de Clientes</title>");
        out.print("  <link rel='stylesheet' href='" + request.getContextPath() + "/consulta_web.css'>");
        out.print("</head>");
        out.print("<body>");

        out.print("<header class='encabezado'>");
        out.print("  <h3>Bootcamp Market</h3>");
        out.print("  <nav>");
        out.print("    <a href='menu_consultas.html' class='navlink'>Volver al Menú Consultas</a>");
        out.print("  </nav>");
        out.print("</header>");

        out.print("<div class='contenedor1'>");
        out.print("  <h3>Top Clientes con mas facturas</h3>");

        // Tabla de resultados
        out.print("  <table>");
        out.print("    <thead>");
        out.print("      <tr><th>ID</th><th>Nombre</th><th>Apellido</th><th>Cantidad de Facturas</th></tr>");
        out.print("    </thead>");
        out.print("    <tbody>");
        try (
                Connection conn = Coneccion.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT c.id, c.nombre,c.apellido, COUNT(f.id) AS cantidad_factura\n" +
                        "FROM cliente c\n" +
                        "LEFT JOIN factura f ON c.id = f.cliente_id\n" +
                        "GROUP BY c.id, c.nombre, c.apellido\n" +
                        "ORDER BY cantidad_factura DESC\n" +
                        "LIMIT 10;")
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int cantidad = rs.getInt("cantidad_factura");
                out.print("      <tr>");
                out.print("        <td>" + id + "</td>");
                out.print("        <td>" + nombre + "</td>");
                out.print("        <td>" + apellido + "</td>");
                out.print("        <td>" + cantidad + "</td>");
                out.print("      </tr>");
            }
        } catch (SQLException e) {
            out.print("      <tr>");
            out.print("        <td colspan='2'>Error al consultar: " + e.getMessage() + "</td>");
            out.print("      </tr>");
        }
        out.print("    </tbody>");
        out.print("  </table>");
        out.print("</body>");
        out.print("</html>");
        out.flush();
    }
}
