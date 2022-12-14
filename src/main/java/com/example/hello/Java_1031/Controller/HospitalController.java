package com.example.hello.Java_1031.Controller;


import com.example.hello.Java_1031.dto.Hospital;
import com.example.hello.Java_1031.dto.HospitalDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/hospital-api")
public class HospitalController {
    private final HospitalDao hospitalDao;
    public HospitalController(HospitalDao hospitalDao){
        this.hospitalDao = hospitalDao;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Hospital> get(@PathVariable Integer id)  {
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);

        if(!opt.isEmpty()){
            return ResponseEntity.ok().body(hospital);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }


    }
}
