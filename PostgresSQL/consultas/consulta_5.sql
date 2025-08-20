SELECT p.id, p.nombre, COUNT(fd.producto_id) AS cantidad
FROM factura_detalle fd
LEFT JOIN producto p ON p.id = fd.producto_id
GROUP BY p.id, p.nombre
ORDER BY cantidad DESC
LIMIT 10;