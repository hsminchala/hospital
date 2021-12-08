package com.hospital.doc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
    class PacienteService {
        @Autowired
        lateinit var pacienteRepository: PacienteRepository


        fun list(): List<PacienteModel> {
            return pacienteRepository.findAll()
        }

        fun update(paciente: PacienteModel): PacienteModel {
            return pacienteRepository.save(paciente)
        }

    fun save(paciente: PacienteModel): PacienteModel {
        return pacienteRepository.save(paciente)
    }

        fun updateNombre (paciente: PacienteModel): PacienteModel {
            try {
                val response = pacienteRepository.findById(paciente.id)
                    ?: throw Exception()
                response.apply {
                    this.nombre = paciente.nombre
                }
                return pacienteRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Paciente no encontrado", ex)
            }
            }

        fun delete (id:Long): Boolean{
            pacienteRepository.deleteById(id)
            return true
        }
    }