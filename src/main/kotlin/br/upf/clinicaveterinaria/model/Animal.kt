package br.upf.clinicaveterinaria.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
data class Animal(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val nome: String,
        val tipo: String,
        val raca: String,
        val observacao: String,

        @ManyToOne
        @JsonBackReference
        val usuario: Usuario,

        @OneToMany(mappedBy = "animal")
        @JsonBackReference
        val agendamentos: List<Agendamento> = listOf()


)
