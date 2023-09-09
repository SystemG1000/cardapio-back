CREATE TABLE foods(
  id SERIAL PRIMARY KEY,
  title TEXT NOT NULL,
  price INTEGER NOT NULL,
  image TEXT
);


-- SERIAL: Auto incrementa
-- PRIMARY KEY: Identificador único
-- NOT NULL: Não pode ser nulo
-- TEXT, INTEGER : Tipo do elemento