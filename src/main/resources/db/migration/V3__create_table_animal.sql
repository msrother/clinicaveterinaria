CREATE TABLE `animal` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `nome` varchar(255) NOT NULL,
 `tipo` varchar(255) NOT NULL,
 `raca` varchar(255) NOT NULL,
 `observacao` varchar(255) DEFAULT NULL,
 `usuario_id` bigint NOT NULL,
  FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
);