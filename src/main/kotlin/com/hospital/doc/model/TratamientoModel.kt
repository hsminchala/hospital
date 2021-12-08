package com.hospital.doc
import javax.persistence.*

@Entity
@Table(name = "tratamiento")
class TratamientoModel{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var descripcion: String? = null
}