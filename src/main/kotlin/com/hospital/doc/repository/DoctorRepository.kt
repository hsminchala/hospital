package com.hospital.doc.repository
import com.hospital.doc.DoctorModel
import org.springframework.data.jpa.repository.JpaRepository

interface DoctorRepository: JpaRepository<DoctorModel, Long> {
        fun findById(id:Long?): DoctorModel?
    }