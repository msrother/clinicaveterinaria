package br.upf.clinicaveterinaria.repository

import br.upf.clinicaveterinaria.model.Consulta
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ConsultaRepository: JpaRepository<Consulta, Long> {

    fun findByTipo(tipoConsulta: String, paginacao: Pageable): Page<Consulta>
}
