package puskesmas.app.patientservice.puskesmasbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import puskesmas.app.patientservice.puskesmasbackend.model.Personal;
import puskesmas.app.patientservice.puskesmasbackend.service.PersonalService;

import java.util.List;

@RestController
@RequestMapping("/v1/personal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonalController {
    @Autowired
    PersonalService personalService;

    @GetMapping("/getListPersonalData")
    public List<Personal> getListPersonalData(){
        return personalService.getListPersonal();
    }

}
