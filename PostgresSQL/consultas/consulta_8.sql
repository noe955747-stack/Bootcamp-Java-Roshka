SELECT f.id, f.fecha_emision, ROUND(SUM(fd.cantidad * p.precio)) AS total
FROM factura f
JOIN factura_detalle fd ON f.id = fd.factura_id
JOIN producto p ON p.id = fd.producto_id
GROUP BY f.id, f.fecha_emision
ORDER BY total DESC
LIMIT 10;