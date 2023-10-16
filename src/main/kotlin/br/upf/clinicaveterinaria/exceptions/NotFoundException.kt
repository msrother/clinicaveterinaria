package br.upf.clinicaveterinaria.exceptions

import java.lang.RuntimeException
class NotFoundException(override val message: String)
    : RuntimeException()