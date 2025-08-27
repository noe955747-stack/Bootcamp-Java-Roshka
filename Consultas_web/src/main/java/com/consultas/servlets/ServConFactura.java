package com.consultas.servlets;

import com.consultas.db.Coneccion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ServConFactura")
public class ServConFactura extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.resetBuffer();
        PrintWriter out = response.getWriter();

        String facturaIdParam = request.getParameter("facturaId");
        int facturaId = 0;

        try {
            facturaId = Integer.parseInt(facturaIdParam);
        } catch (NumberFormatException e) {
            out.print("<!DOCTYPE html><html><body>");
            out.print("<h3>ID inválido</h3>");
            out.print("<a href='consulta_factura.html'>Volver</a>");
            out.print("</body></html>");
            return;
        }

        out.print("<!DOCTYPE html>");
        out.print("<html lang='es'>");
        out.print("<head>");
        out.print("<meta charset='UTF-8'>");
        out.print("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
        out.print("<title>Detalle de Factura</title>");
        out.print("<link rel='stylesheet' href='" + request.getContextPath() + "/consulta_web.css'>");
        out.print("</head>");
        out.print("<body>");

        out.print("<header class='encabezado'>");
        out.print("  <h3>Bootcamp Market</h3>");
        out.print("  <nav>");
        out.print("    <a href='menu_consultas.html' class='navlink'>Volver al Menú Consultas</a>");
        out.print("  </nav>");
        out.print("</header>");

        out.print("<div class='contenedor1'>");
        out.print("<h3>Detalle de Factura ID: " + facturaId + "</h3>");
        out.print("<table>");
        out.print("<thead><tr><th>Fecha</th><th>Cliente</th><th>Producto</th><th>Cantidad</th><th>Tipo</th></tr></thead>");
        out.print("<tbody>");

        String sql = "SELECT f.fecha_emision, c.nombre AS nombre_cliente, c.apellido, " +
                "p.nombre AS nombre_producto, fd.cantidad, ft.nombre AS tipo_factura " +
                "FROM factura f " +
                "JOIN cliente c ON c.id = f.cliente_id " +
                "JOIN factura_detalle fd ON f.id = fd.factura_id " +
                "JOIN producto p ON p.id = fd.producto_id " +
                "JOIN factura_tipo ft ON ft.id = f.factura_tipo_id " +
                "WHERE f.id = ?";

        try (Connection conn = Coneccion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, facturaId);
            ResultSet rs = ps.executeQuery();

            boolean hayResultados = false;
            while (rs.next()) {
                hayResultados = true;
                out.print("<tr>");
                out.print("<td>" + rs.getString("fecha_emision") + "</td>");
                out.print("<td>" + rs.getString("nombre_cliente") + " " + rs.getString("apellido") + "</td>");
                out.print("<td>" + rs.getString("nombre_producto") + "</td>");
                out.print("<td>" + rs.getInt("cantidad") + "</td>");
                out.print("<td>" + rs.getString("tipo_factura") + "</td>");
                out.print("</tr>");
            }

            if (!hayResultados) {
                out.print("<tr><td colspan='5'>No se encontró la factura</td></tr>");
            }

        } catch (SQLException e) {
            out.print("<tr><td colspan='5'>Error: " + e.getMessage() + "</td></tr>");
        }

        out.print("</tbody>");
        out.print("</table>");
        out.print("<p><a href='FormConFactura.html' class='boton1'>Consultar otra factura</a></p>");
        out.print("</div>");
        out.print("</body>");
        out.print("</html>");
        out.flush();
    }
}