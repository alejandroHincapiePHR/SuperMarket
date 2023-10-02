CREATE TABLE Person (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    telefonNumber VARCHAR(255)
);

CREATE TABLE Customer (
    customerId INT AUTO_INCREMENT PRIMARY KEY,
    points INT,
    personId INT,
    FOREIGN KEY (personId) REFERENCES Person(Id)
);

CREATE TABLE Employee (
    employeeId INT AUTO_INCREMENT PRIMARY KEY,
    position VARCHAR(255),
    salary INT,
    personId INT,
    FOREIGN KEY (personId) REFERENCES Person(Id)
);

-- Inserciones para la tabla Person
INSERT INTO person (firstName, lastName, email, telefonNumber)
VALUES
    ('Juan', 'Pérez', 'juan.perez@email.com', '123-456-7890'),
    ('María', 'Gómez', 'maria.gomez@email.com', '987-654-3210'),
    ('Carlos', 'López', 'carlos.lopez@email.com', '555-123-4567'),
    ('Sofía', 'Martínez', 'sofia.martinez@email.com', '777-888-9999'),
    ('Pedro', 'Ramírez', 'pedro.ramirez@email.com', '111-222-3333'),
    ('Laura', 'Fernández', 'laura.fernandez@email.com', '444-555-6666'),
    ('Luis', 'Díaz', 'luis.diaz@email.com', '999-000-1111'),
    ('Ana', 'García', 'ana.garcia@email.com', '333-444-5555'),
    ('Miguel', 'Torres', 'miguel.torres@email.com', '666-777-8888'),
    ('Lucía', 'Ortega', 'lucia.ortega@email.com', '222-111-0000'),
    ('Patricia', 'Hernández', 'patricia.hernandez@email.com', '777-333-1111'),
    ('Roberto', 'Cabrera', 'roberto.cabrera@email.com', '555-666-9999'),
    ('Isabel', 'Vargas', 'isabel.vargas@email.com', '111-000-2222'),
    ('Alejandro', 'Rojas', 'alejandro.rojas@email.com', '999-111-3333'),
    ('Carmen', 'Molina', 'carmen.molina@email.com', '888-555-2222');

-- Inserciones para las posiciones de empleados
INSERT INTO employee (position, salary, personId)
VALUES
    ('CAJERO', 2500000, 1), -- Asociado a la persona con Id = 1
    ('REPOSITOR', 2200000, 2), -- Asociado a la persona con Id = 2
    ('GERENTE', 5000000, 3), -- Asociado a la persona con Id = 3
    ('SUPERVISOR', 3500000, 4), -- Asociado a la persona con Id = 4
    ('EMPACADOR', 1800000, 5); -- Asociado a la persona con Id = 5

-- Inserciones para clientes (incluyendo a los empleados)
INSERT INTO customer (points, personId)
VALUES
    (3500, 6),  -- Asociado a la persona con Id = 6
    (7800, 7),  -- Asociado a la persona con Id = 7
    (4200, 8),  -- Asociado a la persona con Id = 8
    (9800, 9),  -- Asociado a la persona con Id = 9
    (1500, 10), -- Asociado a la persona con Id = 10
    (6400, 11), -- Asociado a la persona con Id = 11
    (8700, 12), -- Asociado a la persona con Id = 12
    (5600, 13), -- Asociado a la persona con Id = 13
    (3200, 14), -- Asociado a la persona con Id = 14
    (9200, 15), -- Asociado a la persona con Id = 15
    (2500, 1),  -- Empleado 1 también como cliente con 2500 puntos
    (2200, 2),  -- Empleado 2 también como cliente con 2200 puntos
    (5000, 3),  -- Empleado 3 también como cliente con 5000 puntos
    (3500, 4),  -- Empleado 4 también como cliente con 3500 puntos
    (1800, 5);  -- Empleado 5 también como cliente con 1800 puntos
