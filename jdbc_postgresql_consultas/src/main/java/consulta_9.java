import java.sql.*;

public class consulta_9 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT f.id, f.fecha_emision, ROUND(SUM(fd.cantidad * p.precio)) AS total,ROUND(SUM(fd.cantidad * p.precio) * 0.10) AS IVA \n" +
                "FROM factura f\n" +
                "JOIN factura_detalle fd ON f.id = fd.factura_id\n" +
                "JOIN producto p ON p.id = fd.producto_id\n" +
                "GROUP BY f.id, f.fecha_emision\n" +
                "ORDER BY total DESC\n" +
                "LIMIT 10;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id------Fecha--------Total--------IVA(10%)");
        while (rs.next()) {
            int id = rs.getInt("id");
            Date fecha = rs.getDate("fecha_emision");
            int total = rs.getInt("total");
            int iva = rs.getInt("IVA");
            System.out.println(id+"--------"+fecha+"--------"+total+"--------"+iva);
        }
    }
}
