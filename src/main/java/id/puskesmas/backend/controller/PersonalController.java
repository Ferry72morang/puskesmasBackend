package id.puskesmas.backend.controller;

import id.puskesmas.backend.model.Personal;
import id.puskesmas.backend.service.PersonalService;
import id.puskesmas.backend.util.ErrorResponse;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("v1/personal")
public class PersonalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    private PersonalService personalService;

    @GetMapping(path = "/getListPersonalData")
    @Operation(summary = "Mendapatkan list data personal")
    public ResponseEntity<?> getListPersonal(){
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        List<Personal> data = personalService.listPersonal();
        if(data.isEmpty()){
            ErrorResponse err = new ErrorResponse();
            err.setStatus("Not found");
            err.setMessage("Data tidak ditemukan");
            return ResponseEntity.status(404).body(err);
        }else{
            res.put("status", true);
            res.put("message", "success");
            res.put("data", data);

            return ResponseEntity.ok().body(res);
        }
    }

    @PostMapping(path = "/addPersonal")
    @Operation(summary = "Mendaftarkan list data personal")
    public void addPersonalData(@RequestBody Personal personal){
         personalService.addPersonal(personal);
    }
}
