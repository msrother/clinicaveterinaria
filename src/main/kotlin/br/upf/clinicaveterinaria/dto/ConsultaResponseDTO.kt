package br.upf.clinicaveterinaria.dto


data class ConsultaResponseDTO(
        val id: Long?,
        val tipo: String,
        val valor: Double,
        val funcionario: String,
        val observacao: String
)
