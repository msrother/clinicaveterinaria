package br.upf.clinicaveterinaria.converters

import br.upf.clinicaveterinaria.dto.AgendamentoDTO
import br.upf.clinicaveterinaria.dto.AgendamentoResponseDTO
import br.upf.clinicaveterinaria.dto.ConsultaResponseDTO
import br.upf.clinicaveterinaria.model.Agendamento
import br.upf.clinicaveterinaria.model.Animal
import br.upf.clinicaveterinaria.model.Consulta
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class AgendamentoConverter {
    fun toAgendamento(dto: AgendamentoDTO): Agendamento {
        return Agendamento(
            data_agendamento = dto.data_agendamento,
            consulta = dto.consulta_id,
            animal = dto.animal_id
        )
    }

    fun toAgendamentoResponseDTO(agendamento: Agendamento) : AgendamentoResponseDTO {
        return AgendamentoResponseDTO(
            id = agendamento.id,
            data_agendamento = agendamento.data_agendamento
        )
    }

    private fun AgendamentoResponseDTO(id: Long?, data_agendamento: LocalDate): AgendamentoResponseDTO {
        TODO("Not yet implemented")
    }
}