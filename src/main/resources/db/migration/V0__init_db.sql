CREATE TABLE persons (
    id INT NOT NULL PRIMARY key auto_increment,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL
);

CREATE TABLE companies (
    id INT NOT NULL PRIMARY key auto_increment,
    name VARCHAR(200) NOT NULL
);

INSERT INTO persons (first_name, last_name) VALUES
('Bill', 'Gates'),
('Steve', 'Jobs'),
('Michael', 'Dell'),
('Jeff', 'Bezos');

INSERT INTO companies (name) VALUES
('Microsoft'),
('Apple'),
('Dell'),
('Amazon');
