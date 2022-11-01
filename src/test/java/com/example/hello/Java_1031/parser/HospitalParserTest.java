package com.example.hello.Java_1031.parser;

import com.example.hello.Java_1031.dto.Hospital;
import com.example.hello.Java_1031.dto.HospitalDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HospitalParserTest {

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;

    @Test
    @DisplayName("Hospital이 insert가 잘 되는지")
    void add(){
        HospitalParser hp = new HospitalParser();
        Hospital hospital = new Hospital();
        hospitalDao.add(hospital);
    }

    @Test
    @DisplayName("제발요")
    void name() throws IOException {
        String filename="/Users/byeonheungseob/Downloads/hospital.csv";
        List<Hospital> hospitalList=hospitalReadLineContext.readByLine(filename);
        assertTrue(hospitalList.size()>10000);
    }
}