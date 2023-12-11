create DATABASE products;
create DATABASE orders;
create DATABASE keycloak;

GRANT ALL PRIVILEGES ON `products`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON `orders`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON `keycloak`.* TO 'admin'@'%';
