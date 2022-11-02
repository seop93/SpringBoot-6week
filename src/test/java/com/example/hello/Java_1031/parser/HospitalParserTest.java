package com.example.hello.Java_1031.parser;

import com.example.hello.Java_1031.dto.Hospital;
import com.example.hello.Java_1031.dto.HospitalDao;
import com.example.hello.Java_1031.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalParserTest {
    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;

    @Test
    @DisplayName("만건 이상 데이터가 파싱되는지 ")
    void name() throws IOException {
        String filename = "/Users/byeonheungseob/Downloads/hospital.csv";
        List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
        assertTrue(hospitalList.size() > 10000);
    }


    // @Test
    //@DisplayName("만건 이상 데이터 파싱이 되는지")
/*    void name() throws IOException {
        String filename="/Users/byeonheungseob/Downloads/hospital.csv";
        List<Hospital> hospitalList=hospitalReadLineContext.readByLine(filename);
        assertTrue(hospitalList.size()>10000);
    }*/

/*    @Test
    @DisplayName("Delete가 잘되는지")
    void deleteAll(){
        hospitalDao.deleteAll();
        assertEquals(0, hospitalDao.getCount());
    }*/

    /*
        @Test
        @DisplayName("10만건 이상 데이터가 파싱 되는지")
        void oneHundreadThousandRows() throws IOException {
            // 서버환경에서 build할 때 문제가 생길 수 있습니다.
            // 어디에서든지 실행할 수 있게 짜는 것이 목표.
            hospitalDao.deleteAll();
            String filename = "/Users/byeonheungseob/Downloads/hospital.csv";
            int cnt = this.hospitalService.insertLargeVolumeHospitalData(filename);
            assertTrue(cnt > 1000);
            assertTrue(cnt > 10000);
            System.out.printf("파싱된 데이터 개수:%d", cnt);
        }
    */
    @Test
    @DisplayName("csv 1줄을 Hospital로 잘만드는지 Test")
    void convertToHospital() {
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);

        assertEquals(1, hospital.getId());
        assertEquals("의원", hospital.getOpenServiceName());
        assertEquals(3620000, hospital.getOpenLocalGovermentCode());
        assertEquals
                ("PHMA119993620020041100004", hospital.getManagementNumber());
        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate());
        assertEquals(1, hospital.getBusinessStatus());
        assertEquals(13, hospital.getBusinessStatusCode());
        assertEquals("062-515-2875", hospital.getPhone());
        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());
        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());
        assertEquals("효치과의원", hospital.getHospitalName());
        assertEquals("치과의원", hospital.getBusinessTypeName());
        assertEquals(1, hospital.getHealthcareProviderCount());
        assertEquals(0, hospital.getPatientRoomCount());
        assertEquals(0, hospital.getTotalNumberOfBeds());
        assertEquals(52.29f, hospital.getTotalAreaSize());
    }

/*
    @Test
    @DisplayName("findById가 잘 되는지")
    void findByIdTest() throws SQLException,ClassNotFoundException {
        HospitalParser hp=new HospitalParser();
        Hospital hospital= hp.parse(line1);
        hospitalDao.add(hospital);
        Hospital findHospital=hospitalDao.findById("1");
        assertEquals(hospital.getHospitalName(), findHospital.getHospitalName());
    }
*/

}
