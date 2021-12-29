package com.travel.helper.controller;

import com.travel.helper.model.TravelResult;
import com.travel.helper.service.TravelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TravelController.class)
public class TravelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TravelService travelService;

    @Test
    public void testReturnsSuccess() throws Exception {
        TravelResult response = new TravelResult(4, LocalDate.parse("2022-01-14"), new ArrayList<>());
        String responseBody = "{\"daysCount\":4,\"endDate\":\"2022-01-14\",\"mandatoryItemList\":[]}";
        given(travelService.getTravelHelperResult(100d, 2, LocalDate.parse("2022-01-10"))).willReturn(response);

        this.mockMvc.perform(get("/api/travel")
                        .queryParam("length", "100")
                        .queryParam("travellers", "2")
                        .queryParam("startDate", "2022-01-10")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(responseBody));
    }

    @Test
    public void testReturnsSuccessWithoutDate() throws Exception {
        TravelResult response = new TravelResult(4, LocalDate.now(), new ArrayList<>());
        String responseBody = "{\"daysCount\":4,\"endDate\":\"" + LocalDate.now() + "\",\"mandatoryItemList\":[]}";
        given(travelService.getTravelHelperResult(100d, 2, LocalDate.now())).willReturn(response);

        this.mockMvc.perform(get("/api/travel")
                        .queryParam("length", "100")
                        .queryParam("travellers", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(responseBody));
    }

    @Test
    public void testReturnsBadRequestWithoutLength() throws Exception {
        this.mockMvc.perform(get("/api/travel")
                        .queryParam("travellers", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testReturnsSuccessWithoutTravellers() throws Exception {
        this.mockMvc.perform(get("/api/travel")
                        .queryParam("length", "100")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testReturnsBadRequestWithoutMinLength() throws Exception {
        this.mockMvc.perform(get("/api/travel")
                        .queryParam("length", "0")
                        .queryParam("travellers", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testReturnsSuccessWithoutMinTravellers() throws Exception {
        this.mockMvc.perform(get("/api/travel")
                        .queryParam("length", "100")
                        .queryParam("travellers", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
