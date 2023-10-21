CREATE TABLE `agendamento` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `dataAgendamento` varchar(255) NOT NULL,
 `consulta_id` bigint NOT NULL,
 `animal_id` bigint NOT NULL,
 FOREIGN KEY (`consulta_id`) REFERENCES `consulta` (`id`),
 FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`)
);