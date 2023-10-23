package br.upf.clinicaveterinaria.service

import br.upf.clinicaveterinaria.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    val repository: UsuarioRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String) =
        repository.findByEmail(email)

}