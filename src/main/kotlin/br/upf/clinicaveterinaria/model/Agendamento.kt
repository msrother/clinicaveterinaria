package br.upf.clinicaveterinaria.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Agendamento(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val data_agendamento: LocalDate,

        @ManyToOne
        @JoinColumn(name = "consulta_id")
        @JsonManagedReference
        val consulta: Consulta,

        @ManyToOne
        @JoinColumn(name = "animal_id")
        @JsonManagedReference
        val animal: Animal,
)
