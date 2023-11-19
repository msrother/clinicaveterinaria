package br.upf.clinicaveterinaria.controller

import br.upf.clinicaveterinaria.dto.AgendamentoDTO
import br.upf.clinicaveterinaria.dto.AgendamentoResponseDTO
import br.upf.clinicaveterinaria.service.AgendamentoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/agendamentos")
class AgendamentoController(val service: AgendamentoService) {

    @GetMapping
    fun listar(): List<AgendamentoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AgendamentoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar (@RequestBody @Valid dto: AgendamentoDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<AgendamentoResponseDTO> {
        val agendamentoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/agendamentos/${agendamentoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(agendamentoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar (@PathVariable id: Long, @RequestBody @Valid dto: AgendamentoDTO): AgendamentoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar (@PathVariable id: Long) {
        service.deletar(id)
    }

}