DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL

);