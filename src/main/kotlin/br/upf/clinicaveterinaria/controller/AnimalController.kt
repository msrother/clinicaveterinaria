package br.upf.clinicaveterinaria.controller

import br.upf.clinicaveterinaria.dto.AnimalDTO
import br.upf.clinicaveterinaria.dto.AnimalResponseDTO
import br.upf.clinicaveterinaria.service.AnimalService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/animais")
class AnimalController(val service: AnimalService) {

    @GetMapping
    fun listar(): List<AnimalResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AnimalResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: AnimalDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AnimalResponseDTO> {
        val userResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/animais/${userResponse.id}")
                .build().toUri()
        return ResponseEntity.created(uri).body(userResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: AnimalDTO
    ): AnimalResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}