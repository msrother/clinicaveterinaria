package br.upf.clinicaveterinaria.repository

import br.upf.clinicaveterinaria.model.Animal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnimalRepository: JpaRepository<Animal, Long> {

}
