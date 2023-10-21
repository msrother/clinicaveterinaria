package br.upf.clinicaveterinaria.dto

import br.upf.clinicaveterinaria.model.Agendamento


data class ConsultaResponseDTO(
        val id: Long?,
        val tipo: String,
        val valor: Double,
        val funcionario: String,
        val observacao: String,
        val agendamentos: List<Agendamento>
)
