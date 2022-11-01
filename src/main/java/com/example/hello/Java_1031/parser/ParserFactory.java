package com.example.hello.Java_1031.parser;

import com.example.hello.Java_1031.dto.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory {
        @Bean
        public ReadLineContext<Hospital> hospitalReadLineContext() {
            return new ReadLineContext<Hospital>(new HospitalParser());
        }



}
