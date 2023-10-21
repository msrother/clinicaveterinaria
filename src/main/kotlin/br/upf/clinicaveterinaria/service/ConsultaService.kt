package br.upf.clinicaveterinaria.service

import br.upf.clinicaveterinaria.converters.ConsultaConverter
import br.upf.clinicaveterinaria.dto.ConsultaDTO
import br.upf.clinicaveterinaria.dto.ConsultaResponseDTO
import br.upf.clinicaveterinaria.repository.ConsultaRepository
import br.upf.clinicaveterinaria.exceptions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val CONSULTA_NOT_FOUND_MESSAGE = "Consulta não encontrada!"
@Service
class ConsultaService(
        private val repository: ConsultaRepository,
        private val converter: ConsultaConverter
) {
    fun listar(
            tipoConsulta: String?,
            paginacao: Pageable): Page<ConsultaResponseDTO> {
        val consultas = if (tipoConsulta == null){
            repository.findAll(paginacao)
        } else {
            repository.findByTipo(tipoConsulta, paginacao)
        }
        return consultas
                .map(converter::toConsultaResponseDTO)
    }
    fun buscarPorId(id: Long): ConsultaResponseDTO {
        val consulta = repository.findById(id).orElseThrow { NotFoundException(CONSULTA_NOT_FOUND_MESSAGE) }
        return converter.toConsultaResponseDTO(consulta)
    }
    fun cadastrar(dto: ConsultaDTO): ConsultaResponseDTO {
        return converter.toConsultaResponseDTO(repository.save(converter.toConsulta(dto)))
    }

    fun atualizar(id: Long, dto: ConsultaDTO): ConsultaResponseDTO {
        val consulta = repository.findById(id)
            .orElseThrow { NotFoundException(CONSULTA_NOT_FOUND_MESSAGE) }
                .copy(
                        tipo = dto.tipo,
                        valor = dto.valor,
                        funcionario = dto.funcionario,
                        observacao = dto.observacao
                )
        return converter.toConsultaResponseDTO(repository.save(consulta))
    }

    fun deletar (id: Long) {
        repository.deleteById(id)
    }

}