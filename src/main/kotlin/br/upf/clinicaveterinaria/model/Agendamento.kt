package br.upf.clinicaveterinaria.model

import java.time.LocalDate

data class Agendamento(
        val id: Long? = null,
        val data_agendamento: LocalDate,
        val animal: Animal,
        val consulta: Consulta
)
