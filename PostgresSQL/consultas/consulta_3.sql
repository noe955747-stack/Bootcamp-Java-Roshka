SELECT m.id, m.nombre, COUNT(f.moneda_id) AS cantidad
FROM factura f
LEFT JOIN moneda m ON m.id = f.moneda_id
GROUP BY m.id, m.nombre
ORDER BY cantidad DESC
LIMIT 10;