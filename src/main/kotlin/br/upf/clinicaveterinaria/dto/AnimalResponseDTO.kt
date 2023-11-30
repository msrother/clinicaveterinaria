package br.upf.clinicaveterinaria.dto

import br.upf.clinicaveterinaria.model.Agendamento
import br.upf.clinicaveterinaria.model.Usuario

data class AnimalResponseDTO(
        val id: Long? = null,
        val nome: String,
        val tipo: String,
        val raca: String,
        val observacao: String,
        val usuario_id: Usuario,
        val agendamentos: List<Agendamento>
)