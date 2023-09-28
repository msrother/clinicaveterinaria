package br.upf.clinicaveterinaria.controller

import br.upf.clinicaveterinaria.dto.ConsultaDTO
import br.upf.clinicaveterinaria.dto.ConsultaResponseDTO
import br.upf.clinicaveterinaria.service.ConsultaService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/consultas")
class ConsultaController(val service: ConsultaService) {

    @GetMapping
    fun listar():List<ConsultaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ConsultaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar (@RequestBody @Valid dto: ConsultaDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<ConsultaResponseDTO> {
        val consultaResponse = service.cadastrar(dto)
        var uri = uriBuilder.path("/consultas/${consultaResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(consultaResponse)
    }

    @PutMapping("/{id}")
    fun atualizar (@PathVariable id: Long, @RequestBody @Valid dto: ConsultaDTO): ConsultaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletar (@PathVariable id: Long) {
        service.deletar(id)
    }

}