CREATE TABLE `consulta` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `tipo` varchar(255) NOT NULL,
 `valor` double(10,2) NOT NULL,
 `funcionario` varchar(255) NOT NULL,
 `observacao` varchar(255) DEFAULT NULL
);