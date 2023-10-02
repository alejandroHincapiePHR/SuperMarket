-- Crear la base de datos "supermarket"
CREATE DATABASE supermarket;

-- Seleccionar la base de datos "supermarket" para trabajar en ella
USE supermarket;

-- Crear la tabla "product" con los campos especificados
CREATE TABLE product (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    SKU VARCHAR(255),
    expirationDate DATE,
    productName VARCHAR(255),
    productManufacturer VARCHAR(255),
    productType VARCHAR(255),
    availableUnits INT,
    customerCost DOUBLE,
    companyCost DOUBLE
);

-- Insertar productos de tipo ALIMENTO
INSERT INTO product (SKU, expirationDate, productName, productManufacturer, productType, availableUnits, customerCost, companyCost)
VALUES
    ('SKU001', '2024-03-15', 'Arroz Blanco', 'Alimentos S.A.', 'ALIMENTO', 100, 5000, 4000),
    ('SKU002', '2024-03-20', 'Leche Deslactosada', 'Lácteos y Más', 'ALIMENTO', 80, 6000, 4800),
    ('SKU003', '2024-04-10', 'Aceite de Oliva Extra Virgen', 'Aceitera Nacional', 'ALIMENTO', 60, 8000, 6400),
    ('SKU004', '2024-04-05', 'Pan Integral', 'Panadería Saludable', 'ALIMENTO', 120, 3500, 2800),
    ('SKU005', '2024-05-01', 'Pasta de Tomate', 'Salsas Ricas', 'ALIMENTO', 90, 4000, 3200),
    ('SKU006', '2024-05-10', 'Manzanas', 'Frutas Frescas', 'ALIMENTO', 70, 7000, 5600),
    ('SKU007', '2024-06-15', 'Chocolate Negro', 'Dulces Deliciosos', 'ALIMENTO', 110, 4500, 3600);

-- Insertar productos de tipo BEBIDA
INSERT INTO product (SKU, expirationDate, productName, productManufacturer, productType, availableUnits, customerCost, companyCost)
VALUES
    ('SKU008', '2024-03-20', 'Agua Mineral', 'Bebidas Refrescantes', 'BEBIDA', 150, 2000, 1600),
    ('SKU009', '2024-03-25', 'Refresco de Cola', 'Bebidas Gaseosas', 'BEBIDA', 100, 3000, 2400),
    ('SKU010', '2024-04-15', 'Jugo de Naranja', 'Jugos Naturales', 'BEBIDA', 120, 4000, 3200),
    ('SKU011', '2024-04-10', 'Cerveza Artesanal', 'Cervecería Artesana', 'BEBIDA', 90, 6000, 4800),
    ('SKU012', '2024-05-05', 'Vino Tinto Reserva', 'Bodegas Elegantes', 'BEBIDA', 80, 9000, 7200),
    ('SKU013', '2024-05-20', 'Café Tostado', 'Cafetería Aromática', 'BEBIDA', 110, 5500, 4400),
    ('SKU014', '2024-06-10', 'Batido de Frutas', 'Smoothies Saludables', 'BEBIDA', 70, 7000, 5600);

-- Insertar productos de tipo LIMPIEZA
INSERT INTO product (SKU, expirationDate, productName, productManufacturer, productType, availableUnits, customerCost, companyCost)
VALUES
    ('SKU015', NULL, 'Detergente Líquido', 'Productos de Limpieza', 'LIMPIEZA', 200, 4000, 3200),
    ('SKU016', NULL, 'Papel Higiénico', 'Productos de Papel', 'LIMPIEZA', 180, 3000, 2400),
    ('SKU017', NULL, 'Limpiavidrios', 'Limpieza Express', 'LIMPIEZA', 150, 3500, 2800),
    ('SKU018', NULL, 'Desinfectante en Spray', 'Productos de Desinfección', 'LIMPIEZA', 120, 6000, 4800),
    ('SKU019', NULL, 'Escoba y Recogedor', 'Artículos de Limpieza', 'LIMPIEZA', 90, 5500, 4400),
    ('SKU020', NULL, 'Toallas de Cocina', 'Productos de Papel', 'LIMPIEZA', 160, 2500, 2000),
    ('SKU021', NULL, 'Jabón de Lavandería', 'Productos de Limpieza', 'LIMPIEZA', 130, 4500, 3600);

-- Insertar productos de tipo ELECTRONICA
INSERT INTO product (SKU, expirationDate, productName, productManufacturer, productType, availableUnits, customerCost, companyCost)
VALUES
    ('SKU022', NULL, 'Smart TV 4K 55 pulgadas', 'Electronics Inc.', 'ELECTRONICA', 50, 3500000, 2800000),
    ('SKU023', NULL, 'Teléfono Inteligente Android', 'Smartphone Co.', 'ELECTRONICA', 100, 2500000, 2000000),
    ('SKU024', NULL, 'Tableta iPad Pro', 'Apple Inc.', 'ELECTRONICA', 80, 4500000, 3600000),
    ('SKU025', NULL, 'Portátil Dell XPS 15', 'Dell', 'ELECTRONICA', 60, 5500000, 4400000),
    ('SKU026', NULL, 'Cámara DSLR Nikon D850', 'Nikon', 'ELECTRONICA', 40, 4000000, 3200000),
    ('SKU027', NULL, 'Reproductor de Blu-ray', 'Electronics Inc.', 'ELECTRONICA', 70, 800000, 640000),
    ('SKU028', NULL, 'Auriculares Inalámbricos', 'AudioTech', 'ELECTRONICA', 110, 1000000, 800000);

-- Insertar productos de tipo ROPA
INSERT INTO product (SKU, expirationDate, productName, productManufacturer, productType, availableUnits, customerCost, companyCost)
VALUES
    ('SKU029', NULL, 'Camisa de Algodón', 'Moda Elegante', 'ROPA', 90, 80000, 64000),
    ('SKU030', NULL, 'Jeans Denim', 'Moda Casual', 'ROPA', 120, 120000, 96000),
    ('SKU031', NULL, 'Vestido de Fiesta', 'Moda Elegante', 'ROPA', 70, 150000, 120000),
    ('SKU032', NULL, 'Zapatos Deportivos', 'Calzado Deportivo', 'ROPA', 100, 140000, 112000),
    ('SKU033', NULL, 'Chaqueta de Cuero', 'Moda Elegante', 'ROPA', 60, 250000, 200000),
    ('SKU034', NULL, 'Sombrero de Paja', 'Moda Veraniega', 'ROPA', 80, 35000, 28000),
    ('SKU035', NULL, 'Traje de Baño', 'Moda de Playa', 'ROPA', 110, 90000, 72000);

