package br.upf.clinicaveterinaria.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ServicoDTO(
        @field:NotBlank(message="Tipo do serviço deve sermpre ser especificado!")
        val tipo: String,
        val valor: Double,
        @field:NotNull(message = "Sempre deve ter o nome do funcionário!")
        val funcionario: String,
        val observacao: String,
)
