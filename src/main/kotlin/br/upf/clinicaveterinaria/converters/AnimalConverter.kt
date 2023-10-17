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
                dono_observacao = animal.dono_observacao
        )
    }

    fun toAnimal(dto: AnimalDTO): Animal {
        return Animal(
                nome = dto.nome,
                tipo = dto.tipo,
                raca = dto.raca,
                dono_observacao = dto.dono_observacao
        )
    }
}