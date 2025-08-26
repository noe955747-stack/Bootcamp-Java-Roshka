package com.consultas.servlets;
import com.consultas.db.Coneccion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/ServCliente")
public class ServCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().println("✅ Servlet activo");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nro_cedula = request.getParameter("nro_cedula");
        String telefono = request.getParameter("telefono");
        int nuevoId = 1; // valor por defecto si la tabla está vacía

        try (Connection conn = Coneccion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM cliente")) {

            if (rs.next()) {
                nuevoId = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("El codigo llego hasta aca");
        try (Connection con = Coneccion.conectar()) {
            String sql = "INSERT INTO cliente (id, nombre, apellido, nro_cedula, telefono) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoId);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, nro_cedula);
            ps.setString(5, telefono);
            ps.executeUpdate();

            out.println("<html><body>");
            out.println("<h3>✅ Cliente agregado correctamente</h3>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<p>Apellido: " + apellido + "</p>");
            out.println("<p>DNI: " + nro_cedula + "</p>");
            out.println("<p>Teléfono: " + telefono + "</p>");
            out.println("<a href='menu_principal.html'>Volver al menú</a>");
            out.println("</body></html>");

        } catch (SQLException e) {
            out.println("<html><body>");
            out.println("<h3> Error al guardar</h3>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='menu_principal.html'>Volver al menú</a>");
            out.println("</body></html>");
        }
    }
}
