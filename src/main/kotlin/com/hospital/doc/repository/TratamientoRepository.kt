package com.hospital.doc
import org.springframework.data.jpa.repository.JpaRepository

interface TratamientoRepository: JpaRepository<TratamientoModel, Long> {
        fun findById(id:Long?): TratamientoModel?
    }