package com.hospital.doc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/doctor")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DoctorController {
    @Autowired
    lateinit var doctorService: DoctorService

    @GetMapping
    fun list(): List<DoctorModel>{
        return doctorService.list()
    }

    @PostMapping
    fun save(@RequestBody doctor: DoctorModel): DoctorModel {
        return doctorService.save(doctor)
    }

    @PutMapping
    fun update (@RequestBody customerAll: DoctorModel): DoctorModel {
        return doctorService.update(customerAll)
    }

    @PatchMapping
    fun patch(@RequestBody doctor: DoctorModel): DoctorModel {
        return doctorService.updateNombre(doctor)
    }


    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return doctorService.delete(id)
    }
}