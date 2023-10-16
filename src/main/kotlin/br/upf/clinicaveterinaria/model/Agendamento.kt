package br.upf.clinicaveterinaria.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
data class Agendamento(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val data_agendamento: LocalDate,
        @ManyToOne
        val animal: Animal,
        @ManyToOne
        val consulta: Consulta
)
