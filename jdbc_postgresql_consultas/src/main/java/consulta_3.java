import java.sql.*;

public class consulta_3 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT m.id, m.nombre, COUNT(f.moneda_id) AS cantidad\n" +
                "FROM factura f\n" +
                "LEFT JOIN moneda m ON m.id = f.moneda_id\n" +
                "GROUP BY m.id, m.nombre\n" +
                "ORDER BY cantidad DESC\n" +
                "LIMIT 10;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id------Nombre--------Cantidad Usos");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int cantidad = rs.getInt("cantidad");
            System.out.println(id+"--------"+nombre+"--------"+cantidad);
        }
    }
}
