package com.consultas.servlets;
import com.consultas.db.Coneccion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/ServPais")
public class ServPais extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.resetBuffer();
        PrintWriter out = response.getWriter();

        String nombre = request.getParameter("nombre");
        int nuevoId = 1;

        try (Connection conn = Coneccion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM pais")) {

            if (rs.next()) {
                nuevoId = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            out.print("<!DOCTYPE html>");
            out.print("<html lang='es'>");
            out.print("<head>");
            out.print("  <meta charset='UTF-8'>");
            out.print("  <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.print("  <title>Error al obtener ID</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("  <h3>Error al obtener el ID</h3>");
            out.print("  <p>" + e.getMessage() + "</p>");
            out.print("  <a href='menu_principal.html'>Volver al menú</a>");
            out.print("</body>");
            out.print("</html>");
            out.flush();
            return;
        }

        response.setContentType("text/html;charset=UTF-8");

        try (Connection con = Coneccion.conectar()) {
            String sql = "INSERT INTO pais (id, nombre) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoId);
            ps.setString(2, nombre);
            ps.executeUpdate();

            out.print("<!DOCTYPE html>");
            out.print("<html lang='es'>");
            out.print("<head>");
            out.print("  <meta charset='UTF-8'>");
            out.print("  <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.print("  <title>Pais Agregado</title>");
            out.print("  <link rel='stylesheet' href='"
                    + request.getContextPath()
                    + "/consulta_web.css'>");
            out.print("</head>");
            out.print("<body>");

            out.print("  <header class='encabezado'>");
            out.print("    <h3>Bootcamp Market</h3>");
            out.print("    <nav>");
            out.print("      <a href='menu_principal.html' class='navlink'>Volver al Menú Principal</a>");
            out.print("    </nav>");
            out.print("  </header>");

            out.print("  <div class='contenedor1'>");
            out.print("    <h3>Pais agregado correctamente</h3>");
            out.print("    <p>Nombre: " + nombre + "</p>");
            out.print("  </div>");

            out.print("</body>");
            out.print("</html>");
            out.flush();

        } catch (SQLException e) {
            out.print("<!DOCTYPE html>");
            out.print("<html lang='es'>");
            out.print("<head>");
            out.print("  <meta charset='UTF-8'>");
            out.print("  <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
            out.print("  <title>Error al guardar</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("  <h3>Error al guardar</h3>");
            out.print("  <p>" + e.getMessage() + "</p>");
            out.print("  <a href='menu_principal.html'>Volver al menú</a>");
            out.print("</body>");
            out.print("</html>");
            out.flush();
        }
    }
}
