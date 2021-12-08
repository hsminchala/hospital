package com.hospital.doc
import org.springframework.data.jpa.repository.JpaRepository

interface PacienteRepository: JpaRepository<PacienteModel, Long> {
    fun findById(id:Long?): PacienteModel?
}