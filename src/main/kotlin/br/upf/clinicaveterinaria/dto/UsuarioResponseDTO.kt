package br.upf.clinicaveterinaria.dto

data class UsuarioResponseDTO(
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String
)