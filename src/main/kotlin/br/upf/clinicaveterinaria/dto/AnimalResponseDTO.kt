package br.upf.clinicaveterinaria.dto

import br.upf.clinicaveterinaria.model.Agendamento
data class AnimalResponseDTO(
        val id: Long? = null,
        val nome: String,
        val tipo: String,
        val raca: String,
        val observacao: String,
        val agendamentos: List<Agendamento>
)