package br.upf.clinicaveterinaria.model

data class Servico(

        val id: Long? = null,
        val tipo: String,
        val valor: Double,
        val funcionario: String,
        val observacao: String,

        )
