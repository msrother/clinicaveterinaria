package br.upf.clinicaveterinaria.model

data class Consulta(

        val id: Long? = null,
        val tipo: String,
        val valor: Double,
        val funcionario: String,
        val observacao: String,

        )
