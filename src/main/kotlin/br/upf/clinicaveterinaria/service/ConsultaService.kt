package br.upf.clinicaveterinaria.service

import br.upf.clinicaveterinaria.converters.ConsultaConverter
import br.upf.clinicaveterinaria.dto.ConsultaDTO
import br.upf.clinicaveterinaria.dto.ConsultaResponseDTO
import br.upf.clinicaveterinaria.repository.ConsultaRepository


class ConsultaService(
        private val repository: ConsultaRepository,
        private val converter: ConsultaConverter) {
    fun listar(): List<ConsultaResponseDTO>{
        return repository.findAll()
                .map (converter::toConsultaResponseDTO)
    }
    fun buscarPorId(id: Long): ConsultaResponseDTO {
        val consulta = repository.findAll().first { it.id == id }
        return converter.toConsultaResponseDTO(consulta)
    }
    fun cadastrar(dto: ConsultaDTO): ConsultaResponseDTO {
        return converter.toConsultaResponseDTO(repository.cadastrar(converter.toConsulta(dto)))
    }

    fun atualizar(id:Long, dto: ConsultaDTO): ConsultaResponseDTO {
        val consultaAtualizada = repository.update(id, converter.toConsulta(dto))
        return converter.toConsultaResponseDTO(consultaAtualizada)
    }

    fun deletar (id: Long) {
        repository.deletar(id)
    }

}