SELECT f.fecha_emision, c.nombre AS nombre_cliente, c.apellido, 
p.nombre AS nombre_producto, fd.cantidad, ft.nombre AS tipo_factura 
FROM factura f 
JOIN cliente c ON c.id = f.cliente_id 
JOIN factura_detalle fd ON f.id = fd.factura_id 
JOIN producto p ON p.id = fd.producto_id 
JOIN factura_tipo ft ON ft.id = f.factura_tipo_id
WHERE f.id = 105;