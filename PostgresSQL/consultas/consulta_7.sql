SELECT f.fecha_emision, c.nombre, c.apellido, p.nombre, fd.cantidad, ft.nombre
FROM factura f
JOIN cliente c ON c.id = f.cliente_id
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON p.id = fd.producto_id
JOIN factura_tipo ft ON ft.id = f.factura_tipo_id
WHERE f.id = 105;
