package br.upf.clinicaveterinaria.dto

import br.upf.clinicaveterinaria.model.Animal

data class UsuarioResponseDTO(
    val id: Long? = null,
    val nome: String,
    val cidade: String,
    val telefone: String,
    val animais: List<Animal>
)