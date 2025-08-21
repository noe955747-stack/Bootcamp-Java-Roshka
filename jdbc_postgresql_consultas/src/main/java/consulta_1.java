import java.sql.*;

public class consulta_1 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT c.id, c.nombre,c.apellido, COUNT(f.id) AS cantidad_factura " +
                "FROM cliente c " +
                "LEFT JOIN factura f ON c.id = f.cliente_id " +
                "GROUP BY c.id, c.nombre, c.apellido " +
                "ORDER BY cantidad_factura DESC " +
                "LIMIT 10; ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id------Nombre--------Apellido-----Cantidad Facturas");
        while (rs.next()) {
            int id_cliente = rs.getInt("id");
            String nombre_cliente = rs.getString("nombre");
            String apellido_cliente = rs.getString("apellido");
            int cantidad_factura = rs.getInt("cantidad_factura");
            System.out.println(id_cliente+"--------"+nombre_cliente+"--------"+apellido_cliente+"--------"+cantidad_factura);
        }
    }
}
