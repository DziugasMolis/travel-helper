package com.travel.helper.controller;

import com.travel.helper.service.TravelService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping(value = "/api/travel")
public class TravelController {

    @Autowired
    TravelService travelService;

    @GetMapping
    public ResponseEntity<Object> travel(@Parameter(example = "100") @RequestParam Double length,
                                           @Parameter(example = "5") @RequestParam Integer travellers,
                                           @Parameter(example = "2021-12-31") @RequestParam(required = false, defaultValue = "#{T(java.time.LocalDate).now()}") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        if(length <= 0 || travellers < 1) {
            return new ResponseEntity<>("invalid request parameters", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(travelService.getTravelHelperResult(length, travellers, startDate),
                HttpStatus.OK);
    }
}
