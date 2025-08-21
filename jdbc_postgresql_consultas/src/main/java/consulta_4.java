import java.sql.*;
public class consulta_4 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT pr.id, pr.nombre,pr.ruc, COUNT(pr.id) AS cantidad\n" +
                "FROM producto p\n" +
                "LEFT JOIN proveedor pr ON pr.id = p.proveedor_id\n" +
                "GROUP BY pr.id, pr.nombre,pr.ruc\n" +
                "ORDER BY cantidad DESC\n" +
                "LIMIT 10;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Id------Nombre------RUC--------Cantidad Productos");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String ruc= rs.getString("ruc");
            int cantidad = rs.getInt("cantidad");
            System.out.println(id+"--------"+nombre+"--------"+ruc+"--------"+cantidad);
        }
    }
}
