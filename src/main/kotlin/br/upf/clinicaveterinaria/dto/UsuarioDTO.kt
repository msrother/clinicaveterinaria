package br.upf.clinicaveterinaria.dto

data class UsuarioDTO(
    val nome: String,
    val cidade: String,
    val telefone: String,
    val senha: String,
    val email: String
)