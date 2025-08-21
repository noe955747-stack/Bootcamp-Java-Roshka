import java.sql.*;

public class consulta_7 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcamp_market","postgres","PIERRO2025");
        String sql = "SELECT f.fecha_emision, c.nombre AS nombre_cliente, c.apellido, \n" +
                "p.nombre AS nombre_producto, fd.cantidad, ft.nombre AS tipo_factura \n" +
                "FROM factura f \n" +
                "JOIN cliente c ON c.id = f.cliente_id \n" +
                "JOIN factura_detalle fd ON f.id = fd.factura_id \n" +
                "JOIN producto p ON p.id = fd.producto_id \n" +
                "JOIN factura_tipo ft ON ft.id = f.factura_tipo_id\n" +
                "WHERE f.id = 105;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Fecha Emision------Nombre--------Apellido-----Producto-----Cantidad Producto-----Tipo Factura");
        while (rs.next()) {

            Date fecha = rs.getDate("fecha_emision");
            String nombre_cliente = rs.getString("nombre_cliente");
            String apellido_cliente = rs.getString("apellido");
            String nombre_producto = rs.getString("nombre_producto");
            int cantidad = rs.getInt("cantidad");
            String tipo_factura= rs.getString("tipo_factura");
            System.out.println(fecha+"--------"+nombre_cliente+"--------"+apellido_cliente+"--------"+nombre_producto+"--------"+cantidad+"--------"+tipo_factura);
        }
    }
}
