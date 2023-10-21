package br.upf.clinicaveterinaria.controller

import br.upf.clinicaveterinaria.dto.ConsultaDTO
import br.upf.clinicaveterinaria.dto.ConsultaResponseDTO
import br.upf.clinicaveterinaria.service.ConsultaService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/consultas")
class ConsultaController(val service: ConsultaService) {

    @GetMapping
    fun listar(
            @RequestParam(required = false) tipoConsulta: String?,
            @PageableDefault(size = 10) paginacao: Pageable)
    : Page<ConsultaResponseDTO> {
        return service.listar(tipoConsulta, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ConsultaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar (@RequestBody @Valid dto: ConsultaDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<ConsultaResponseDTO> {
        val consultaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/consultas/${consultaResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(consultaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar (@PathVariable id: Long, @RequestBody @Valid dto: ConsultaDTO): ConsultaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar (@PathVariable id: Long) {
        service.deletar(id)
    }

}