package com.consultas.servlets;

import com.consultas.db.Coneccion;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ServConFacturaIVA")
public class ServConFacturaIVA extends HttpServlet {
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
        out.print("  <title>Consulta de Monto Facturas e IVA</title>");
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
        out.print("  <h3>Top Facturas de  mayor monto con IVA</h3>");

        // Tabla de resultados
        out.print("  <table>");
        out.print("    <thead>");
        out.print("      <tr><th>ID</th><th>Fecha de Emision</th><th>Monto Total</th><th>IVA(10%)</th></tr>");
        out.print("    </thead>");
        out.print("    <tbody>");
        try (
                Connection conn = Coneccion.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT f.id, f.fecha_emision, ROUND(SUM(fd.cantidad * p.precio)) AS total,ROUND(SUM(fd.cantidad * p.precio) * 0.10) AS IVA \n" +
                        "FROM factura f\n" +
                        "JOIN factura_detalle fd ON f.id = fd.factura_id\n" +
                        "JOIN producto p ON p.id = fd.producto_id\n" +
                        "GROUP BY f.id, f.fecha_emision\n" +
                        "ORDER BY total DESC\n" +
                        "LIMIT 10;")
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha_emision");
                int monto = rs.getInt("total");
                int iva = rs.getInt("IVA");
                out.print("      <tr>");
                out.print("        <td>" + id + "</td>");
                out.print("        <td>" + fecha + "</td>");
                out.print("        <td>" + monto + "</td>");
                out.print("        <td>" + iva + "</td>");
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
