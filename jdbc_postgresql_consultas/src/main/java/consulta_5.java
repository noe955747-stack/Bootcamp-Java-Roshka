import java.sql.*;

public class consulta_5 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT p.id, p.nombre, COUNT(fd.producto_id) AS cantidad\n" +
                "FROM factura_detalle fd\n" +
                "LEFT JOIN producto p ON p.id = fd.producto_id\n" +
                "GROUP BY p.id, p.nombre\n" +
                "ORDER BY cantidad DESC\n" +
                "LIMIT 10;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id------Nombre--------Cantidad Vendida");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int cantidad = rs.getInt("cantidad");
            System.out.println(id+"--------"+nombre+"--------"+cantidad);
        }
    }
}
