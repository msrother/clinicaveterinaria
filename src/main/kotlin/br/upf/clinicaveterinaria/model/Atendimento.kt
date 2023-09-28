package br.upf.clinicaveterinaria.model

import java.time.LocalDate

data class Atendimento(
        val id: Long? = null,
        val data_atendimento: LocalDate,
        val animal: Animal
)
