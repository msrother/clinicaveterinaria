package br.upf.clinicaveterinaria.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Animal(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val nome: String,
        val tipo: String,
        val raca: String,
        val dono_observacao: String,

        @OneToMany(mappedBy = "animal")
        val consultas: List<Consulta> = listOf()
)
