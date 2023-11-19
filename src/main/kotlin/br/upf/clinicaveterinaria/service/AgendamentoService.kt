package br.upf.clinicaveterinaria.service


import br.upf.clinicaveterinaria.converters.AgendamentoConverter
import br.upf.clinicaveterinaria.dto.AgendamentoDTO
import br.upf.clinicaveterinaria.dto.AgendamentoResponseDTO
import br.upf.clinicaveterinaria.exceptions.NotFoundException
import br.upf.clinicaveterinaria.repository.AgendamentoRepository
import org.springframework.stereotype.Service

private const val AGENDAMENTO_NOT_FOUND_MESSAGE = "Agendamento não encontrado!"
@Service
class AgendamentoService(
        private val repository: AgendamentoRepository,
        private val converter: AgendamentoConverter
) {

    fun listar(): List<AgendamentoResponseDTO> {
        return repository.findAll()
            .map(converter::toAgendamentoResponseDTO)
    }

    fun buscarPorId(id: Long): AgendamentoResponseDTO {
        val agendamento = repository.findById(id).orElseThrow { NotFoundException(AGENDAMENTO_NOT_FOUND_MESSAGE) }
        return converter.toAgendamentoResponseDTO(agendamento)
    }
    fun cadastrar(dto: AgendamentoDTO): AgendamentoResponseDTO {
        return converter.toAgendamentoResponseDTO(repository.save(converter.toAgendamento(dto)))
    }

    fun atualizar(id: Long, dto: AgendamentoDTO): AgendamentoResponseDTO {
        val agendamento = repository.findById(id)
            .orElseThrow { NotFoundException(AGENDAMENTO_NOT_FOUND_MESSAGE) }
            .copy(
                data_agendamento = dto.data_agendamento
            )
        return converter.toAgendamentoResponseDTO(repository.save(agendamento))
    }

    fun deletar (id: Long) {
        repository.deleteById(id)
    }

}