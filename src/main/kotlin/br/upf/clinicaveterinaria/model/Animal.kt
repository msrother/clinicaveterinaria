package br.upf.clinicaveterinaria.model

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
        val usuario: Usuario,

        @OneToMany(mappedBy = "animal")
        val agendamentos: List<Agendamento> = listOf()


)
