package br.upf.clinicaveterinaria.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Consulta(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val tipo: String,
        val valor: Double,
        val funcionario: String,
        val observacao: String,

        @OneToMany(mappedBy = "consulta")
        @JsonBackReference
        val agendamentos: List<Agendamento> = listOf()
)
