package br.upf.clinicaveterinaria.converters

import br.upf.clinicaveterinaria.dto.UsuarioDTO
import br.upf.clinicaveterinaria.dto.UsuarioResponseDTO
import br.upf.clinicaveterinaria.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {

    //função para converter um objeto Usuario para um DTO que será retornado como resposta de uma solicitação
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
            id = usuario.id,
            nome = usuario.nome,
            cidade = usuario.cidade,
            telefone = usuario.telefone,
            animais = usuario.animais
        )
    }

    // função para converter um objeto Usuario para um DTO, mas não necessariamente para uma resposta
    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
            nome = dto.nome,
            cidade = dto.cidade,
            telefone = dto.telefone,
            animais = listOf()
        )
    }
}