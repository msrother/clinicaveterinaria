package br.upf.clinicaveterinaria.repository

import br.upf.clinicaveterinaria.model.Agendamento
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AgendamentoRepository: JpaRepository<Agendamento, Long> {
   // fun findByData(dataAgendamento: String, paginacao: org.springframework.data.domain.Pageable): Page<Agendamento>
}