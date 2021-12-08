package com.hospital.doc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/paciente")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class PacienteController {

    @Autowired
    lateinit var pacienteService: PacienteService

    @GetMapping
    fun list(): List<PacienteModel>{
        return pacienteService.list()
    }

    @PostMapping
    fun save(@RequestBody paciente: PacienteModel): PacienteModel {
        return pacienteService.save(paciente)
    }

    @PutMapping
    fun update (@RequestBody paciente: PacienteModel): PacienteModel {
        return pacienteService.update(paciente)
    }

    @PatchMapping
    fun patch(@RequestBody paciente: PacienteModel): PacienteModel {
        return pacienteService.updateNombre(paciente)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return pacienteService.delete(id)
    }
}