package com.hospital.doc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TratamientoService {
        @Autowired
        lateinit var tratamientoRepository: TratamientoRepository


        fun list(): List<TratamientoModel> {
            return tratamientoRepository.findAll()
        }


    fun save(tratamiento: TratamientoModel): TratamientoModel {
        try{
        if (tratamiento.descripcion.equals("")) {
        throw Exception("Descripcion esta vacia")
        }
        else{
        return tratamientoRepository.save(tratamiento)
    }
        } catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_ACCEPTABLE, "No se aceptan valores nulos"
            )
        }}

        fun update(tratamiento: TratamientoModel): TratamientoModel {
            return tratamientoRepository.save(tratamiento)
        }

        fun updateDescripcion (tratamiento: TratamientoModel): TratamientoModel {
            try {
                val response = tratamientoRepository.findById(tratamiento.id)
                    ?: throw Exception()
                response.apply {
                    this.descripcion = tratamiento.descripcion
                }
                return tratamientoRepository.save(response)
            } catch (ex:Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Descripcion vacia", ex)
            }
        }
        fun delete (id:Long): Boolean{
            tratamientoRepository.deleteById(id)
            return true
        }
    }