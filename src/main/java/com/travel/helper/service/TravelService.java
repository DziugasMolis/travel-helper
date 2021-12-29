package com.travel.helper.service;

import com.travel.helper.model.TravelResult;

import java.time.LocalDate;

public interface TravelService {

    TravelResult getTravelHelperResult(Double length, Integer travellers, LocalDate startDate);
}
