create table libros(
	titulo varchar(20),
	autor varchar(30),
	editorial varchar(15)
);
SELECT column_name, data_type, is_nullable, column_default
FROM information_schema.columns
WHERE table_name = 'libros';
DROP TABLE libros;