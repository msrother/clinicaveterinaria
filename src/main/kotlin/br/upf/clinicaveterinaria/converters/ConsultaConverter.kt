package br.upf.clinicaveterinaria.converters

import br.upf.clinicaveterinaria.dto.ConsultaDTO
import br.upf.clinicaveterinaria.dto.ConsultaResponseDTO
import br.upf.clinicaveterinaria.model.Consulta
import org.springframework.stereotype.Component

@Component
class ConsultaConverter {
    fun toEvento(dto: ConsultaDTO): Consulta {
        return Consulta(
                tipo = dto.tipo,
                valor = dto.valor,
                funcionario = dto.funcionario,
                observacao = dto.observacao,
        )
    }
    fun toConsultaResponseDTO(consulta: Consulta) : ConsultaResponseDTO{
        return ConsultaResponseDTO(
                id = consulta.id,
                tipo = consulta.tipo,
                valor = consulta.valor,
                funcionario = consulta.funcionario,
                observacao =  consulta.observacao
        )
    }
}