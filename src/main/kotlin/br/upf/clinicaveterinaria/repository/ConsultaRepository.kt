package br.upf.clinicaveterinaria.repository

import br.upf.clinicaveterinaria.model.Consulta
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ConsultaRepository: JpaRepository<Consulta, Long> {

    fun findByNome(nomeConsulta: String, paginacao: Pageable): Page<Consulta>
}


//remover esta parte depois

/*
class ConsultaRepository (private var consultas: MutableList<Consulta>) {

    private var idCont = 4L
    init {
        val consulta1 = Consulta(
                id = 1,
                tipo = "Exame de sangue",
                valor = 200.70,
                funcionario = "Matheus",
                observacao = "Coleta na pata esquerda"
        )
        val consulta2 = Consulta(
                id = 2,
                tipo = "Raio X",
                valor = 150.20,
                funcionario = "Kátia",
                observacao = "Torax"
        )
        val consulta3 = Consulta(
                id = 3,
                tipo = "Exame oftalmológico",
                valor = 300.00,
                funcionario = "Matheus",
                observacao = "Olho direito muito inflamado"
        )

        consultas = mutableListOf(consulta1, consulta2, consulta3)
    }

    fun findAll() = consultas

    fun cadastrar(consulta: Consulta): Consulta {
        val consultaComId = consulta.copy(id = idCont++)
        consultas.add(consultaComId)
        return consultaComId
    }

    fun update(id:Long,consultaAtualizada: Consulta):Consulta {
        val consulta = consultas.first {it.id == id}
        consultas.remove(consulta)
        val consultaAtualizadaComId = Consulta(
                id = id,
                tipo = consultaAtualizada.tipo,
                valor = consultaAtualizada.valor,
                funcionario = consultaAtualizada.funcionario,
                observacao = consultaAtualizada.observacao
        )
        consultas.add(consultaAtualizadaComId)
        return consultaAtualizadaComId
    }

    fun deletar (id: Long) {
        consultas.removeIf { it.id == id }
    }


}



 */