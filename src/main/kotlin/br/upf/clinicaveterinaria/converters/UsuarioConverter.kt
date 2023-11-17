package br.upf.clinicaveterinaria.converters

import br.upf.clinicaveterinaria.dto.UsuarioDTO
import br.upf.clinicaveterinaria.dto.UsuarioResponseDTO
import br.upf.clinicaveterinaria.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
            id = usuario.id,
            nome = usuario.nome,
            cidade = usuario.cidade,
            telefone = usuario.telefone
        )
    }

    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
            nome = dto.nome,
            cidade = dto.cidade,
            telefone = dto.telefone
        )
    }
}