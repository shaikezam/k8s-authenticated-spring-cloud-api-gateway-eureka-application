create DATABASE products;
create DATABASE orders;
create DATABASE keycloak;
create DATABASE spring_session;

GRANT ALL PRIVILEGES ON `products`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON `orders`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON `keycloak`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON `spring_session`.* TO 'admin'@'%';
