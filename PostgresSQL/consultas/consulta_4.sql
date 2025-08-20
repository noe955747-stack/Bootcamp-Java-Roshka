SELECT pr.id, pr.nombre,pr.ruc, COUNT(pr.id) AS cantidad
FROM producto p
LEFT JOIN proveedor pr ON pr.id = p.proveedor_id
GROUP BY pr.id, pr.nombre,pr.ruc
ORDER BY cantidad DESC
LIMIT 10;