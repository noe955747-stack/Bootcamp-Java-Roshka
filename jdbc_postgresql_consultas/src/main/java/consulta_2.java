import java.sql.*;

public class consulta_2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT c.id, c.nombre,c.apellido, ROUND(SUM(fd.cantidad * p.precio)) AS total\n" +
                "FROM cliente c\n" +
                "JOIN factura f ON c.id = f.cliente_id\n" +
                "JOIN factura_detalle fd ON f.id = fd.factura_id\n" +
                "JOIN producto p ON p.id = fd.producto_id\n" +
                "GROUP BY c.id, c.nombre, c.apellido\n" +
                "ORDER BY total DESC\n" +
                "LIMIT 10; ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id------Nombre--------Apellido-----Total Comprado");
        while (rs.next()) {
            int id_cliente = rs.getInt("id");
            String nombre_cliente = rs.getString("nombre");
            String apellido_cliente = rs.getString("apellido");
            int cantidad = rs.getInt("total");
            System.out.println(id_cliente+"--------"+nombre_cliente+"--------"+apellido_cliente+"--------"+cantidad);
        }
    }
}

