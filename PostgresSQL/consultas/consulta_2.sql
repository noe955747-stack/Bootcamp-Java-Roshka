SELECT c.id, c.nombre,c.apellido, ROUND(SUM(fd.cantidad * p.precio)) AS total
FROM cliente c
JOIN factura f ON c.id = f.cliente_id
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON p.id = fd.producto_id
GROUP BY c.id, c.nombre, c.apellido
ORDER BY total DESC
LIMIT 10;