DROP TABLE IF EXISTS category;

CREATE TABLE category(
	category_id INT NOT NULL AUTO_INCREMENT,
    category VARCHAR(100) UNIQUE NOT NULL, 
    acronym VARCHAR(50) UNIQUE NOT NULL,
    status TINYINT NOT NULL,
    PRIMARY KEY (category_id));
    
INSERT INTO product (category_id, category,acronym, status) 
VALUES (1,"Linea Blanca","LB","1");