package br.upf.clinicaveterinaria.service
import br.upf.clinicaveterinaria.converters.AnimalConverter
import br.upf.clinicaveterinaria.dto.AnimalDTO
import br.upf.clinicaveterinaria.exceptions.NotFoundException
import br.upf.clinicaveterinaria.dto.AnimalResponseDTO
import br.upf.clinicaveterinaria.repository.AnimalRepository
import org.springframework.stereotype.Service

private const val ANIMAL_NOT_FOUND_MESSAGE = "Animal não encontrado!"

@Service
class AnimalService(
        private val repository: AnimalRepository,
        private val converter: AnimalConverter
) {
    fun listar(): List<AnimalResponseDTO> {
        return repository.findAll()
                .map(converter::toAnimalResponseDTO)
    }

    fun buscarPorId(id: Long): AnimalResponseDTO {
        val animal = repository.findById(id)
                .orElseThrow { NotFoundException(ANIMAL_NOT_FOUND_MESSAGE) }
        return converter.toAnimalResponseDTO(animal)
    }

    fun cadastrar(dto: AnimalDTO): AnimalResponseDTO {
        return converter.toAnimalResponseDTO(
                repository.save(converter.toAnimal(dto)))
    }

    fun atualizar(id: Long, dto: AnimalDTO): AnimalResponseDTO {
        val animal = repository.findById(id)
                .orElseThrow { NotFoundException(ANIMAL_NOT_FOUND_MESSAGE) }
                .copy(
                        nome = dto.nome,
                        tipo = dto.tipo,
                        raca = dto.raca,
                        dono_obs = dto.dono_obs
                )
        return converter.toAnimalResponseDTO(repository.save(animal))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}