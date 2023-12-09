CREATE TABLE IF NOT EXISTS product (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT NOT NULL,
  price DECIMAL(10, 2) NOT NULL
);

INSERT INTO product (name, description, price) VALUES
('iPhone 12', 'The latest iPhone with advanced features and powerful performance.', 999.99),
('Samsung Galaxy S21', 'A flagship Android smartphone with a stunning display and high-end camera.', 899.99),
('Sony PlayStation 5', 'Next-generation gaming console with cutting-edge graphics and immersive gameplay.', 499.99),
('Dell XPS 13', 'Ultra-slim and powerful laptop with a beautiful display and long battery life.', 1299.99),
('Canon EOS R5', 'Professional mirrorless camera with high-resolution imaging and 8K video capabilities.', 3499.99);
