package br.upf.clinicaveterinaria.converters

import br.upf.clinicaveterinaria.dto.AnimalDTO
import br.upf.clinicaveterinaria.dto.AnimalResponseDTO
import br.upf.clinicaveterinaria.model.Animal
import br.upf.clinicaveterinaria.model.Usuario
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class AnimalConverter {
    fun toAnimalResponseDTO(animal: Animal): AnimalResponseDTO {
        return AnimalResponseDTO(
                id = animal.id,
                nome = animal.nome,
                tipo = animal.tipo,
                raca = animal.raca,
                observacao = animal.observacao
        )
    }

    fun toAnimal(dto: AnimalDTO): Animal {
        val usuarioAtual = SecurityContextHolder.getContext().authentication.principal as Usuario

        return Animal(
                nome = dto.nome,
                tipo = dto.tipo,
                raca = dto.raca,
                observacao = dto.observacao,
                usuario = usuarioAtual
        )
    }
}