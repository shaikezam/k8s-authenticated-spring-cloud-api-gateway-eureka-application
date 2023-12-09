create DATABASE products;
create DATABASE orders;

GRANT ALL PRIVILEGES ON `products`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON `orders`.* TO 'admin'@'%';
