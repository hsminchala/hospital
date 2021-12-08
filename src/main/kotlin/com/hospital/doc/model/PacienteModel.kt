package com.hospital.doc
import javax.persistence.*

@Entity
@Table(name = "paciente")
class PacienteModel{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var edad: String? = null
}