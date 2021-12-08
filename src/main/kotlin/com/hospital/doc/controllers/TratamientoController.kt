package com.hospital.doc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class TratamientoController {

    @Autowired
    lateinit var tratamientoService: TratamientoService

    @GetMapping
    fun list(): List<TratamientoModel>{
        return tratamientoService.list()
    }

    @PostMapping
    fun save(@RequestBody tratamiento: TratamientoModel): TratamientoModel {
        return tratamientoService.save(tratamiento)
    }

    @PutMapping
    fun update (@RequestBody tratamiento: TratamientoModel): TratamientoModel {
        return tratamientoService.update(tratamiento)
    }

    @PatchMapping
    fun patch(@RequestBody tratamiento: TratamientoModel): TratamientoModel {
        return tratamientoService.updateDescripcion(tratamiento)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return tratamientoService.delete(id)
    }
}