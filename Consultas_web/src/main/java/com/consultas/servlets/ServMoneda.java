package com.consultas.servlets;
import com.consultas.db.Coneccion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/ServMoneda")
public class ServMoneda extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String nombre = request.getParameter("nombre");
        int nuevoId = 1;

        try (Connection conn = Coneccion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM moneda")) {

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
            String sql = "INSERT INTO moneda (id, nombre) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoId);
            ps.setString(2, nombre);
            ps.executeUpdate();

            out.println("<html><body><div>");
            out.println("<h3>Moneda agregada correctamente</h3>");
            out.println("<p>Nombre: " + nombre + "</p>");
            out.println("<a href='menu_principal.html'>Volver al menú</a>");
            out.println("</div></body></html>");

        } catch (SQLException e) {
            out.println("<html><body>");
            out.println("<h3> Error al guardar</h3>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='menu_principal.html'>Volver al menú</a>");
            out.println("</body></html>");
        }
    }
}
