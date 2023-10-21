CREATE TABLE `animal` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `nome` varchar(255) NOT NULL,
 `tipo` varchar(255) NOT NULL,
 `raca` varchar(255) NOT NULL,
 `dono_obs` varchar(255) DEFAULT NULL
);