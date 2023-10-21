package br.upf.clinicaveterinaria.dto

data class AnimalResponseDTO(
        val id: Long? = null,
        val nome: String,
        val tipo: String,
        val raca: String,
        val dono_obs: String
)