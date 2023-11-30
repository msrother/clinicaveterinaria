package br.upf.clinicaveterinaria.converters

import br.upf.clinicaveterinaria.dto.AnimalDTO
import br.upf.clinicaveterinaria.dto.AnimalResponseDTO
import br.upf.clinicaveterinaria.model.Animal
import org.springframework.stereotype.Component

@Component
class AnimalConverter {
    fun toAnimalResponseDTO(animal: Animal): AnimalResponseDTO {
        return AnimalResponseDTO(
                id = animal.id,
                nome = animal.nome,
                tipo = animal.tipo,
                raca = animal.raca,
                observacao = animal.observacao,
                agendamentos = animal.agendamentos,
                usuario_id = animal.usuario
        )
    }

    fun toAnimal(dto: AnimalDTO): Animal {

        return Animal(
                nome = dto.nome,
                tipo = dto.tipo,
                raca = dto.raca,
                observacao = dto.observacao,
                agendamentos = listOf(),
                usuario = dto.usuario_id
        )
    }
}