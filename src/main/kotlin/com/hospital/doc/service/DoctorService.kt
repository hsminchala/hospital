package com.hospital.doc
import com.hospital.doc.repository.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DoctorService {
        @Autowired
        lateinit var doctorRepository: DoctorRepository


        fun list(): List<DoctorModel> {

            return doctorRepository.findAll()
        }

    fun save(doctor: DoctorModel): DoctorModel {
        return doctorRepository.save(doctor)
    }

        fun update(doctor: DoctorModel): DoctorModel {
            return doctorRepository.save(doctor)
        }

        fun updateNombre (doctor: DoctorModel): DoctorModel {
            try {
                val response = doctorRepository.findById(doctor.id)
                    ?: throw Exception()
                response.apply {
                    this.nombre = doctor.nombre
                }
                return doctorRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Doctor no encontrado", ex)
            }
        }
        fun delete (id:Long): Boolean{
            doctorRepository.deleteById(id)
            return true
        }
    }