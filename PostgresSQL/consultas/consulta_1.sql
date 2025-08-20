SELECT c.id, c.nombre,c.apellido, COUNT(f.id) AS cantidad_factura
FROM cliente c
LEFT JOIN factura f ON c.id = f.cliente_id
GROUP BY c.id, c.nombre, c.apellido
ORDER BY cantidad_factura DESC
LIMIT 10;