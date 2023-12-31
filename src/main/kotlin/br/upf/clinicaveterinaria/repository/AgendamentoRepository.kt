package br.upf.clinicaveterinaria.repository

import br.upf.clinicaveterinaria.model.Agendamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AgendamentoRepository: JpaRepository<Agendamento, Long> {
}