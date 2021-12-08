package com.hospital.doc
import javax.persistence.*

@Entity
    @Table(name = "doctor")
    class DoctorModel{
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var nombre: String? = null
        var especialidad: String? = null
    }