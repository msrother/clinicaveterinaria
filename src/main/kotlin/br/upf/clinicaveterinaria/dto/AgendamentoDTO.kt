package br.upf.clinicaveterinaria.dto

import br.upf.clinicaveterinaria.model.Animal
import br.upf.clinicaveterinaria.model.Consulta
import java.time.LocalDate

data class AgendamentoDTO(
    val data_agendamento: LocalDate,
    val consulta_id: Consulta,
    val animal_id: Animal


)
