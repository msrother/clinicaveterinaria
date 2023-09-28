package br.upf.clinicaveterinaria.model

data class Animal(
        val id: Long? = null,
        val nome: String,
        val tipo: String,
        val raca: String,
        val dono_observacao: String
)
