package br.upf.clinicaveterinaria.dto

import br.upf.clinicaveterinaria.model.Usuario

data class AnimalDTO(
        val nome: String,
        val tipo: String,
        val raca: String,
        val observacao: String,
        val usuario_id: Usuario
)