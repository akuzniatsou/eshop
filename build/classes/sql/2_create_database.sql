CREATE DATABASE `shop` DEFAULT CHARACTER SET utf8;

GRANT SELECT,INSERT,UPDATE,DELETE
ON `shop`.*
TO shop@localhost
IDENTIFIED BY 'shop';

GRANT SELECT,INSERT,UPDATE,DELETE
ON `shop`.*
TO shop@'%'
IDENTIFIED BY 'shop';