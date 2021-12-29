package com.travel.helper.service;

import com.travel.helper.model.MandatoryItem;
import com.travel.helper.model.MandatoryItemType;
import com.travel.helper.model.TravelResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TravelServiceTest {

    @InjectMocks
    private TravelServiceImpl travelService;

    @Test
    public void testGetSummerItems() {
        TravelResult expectedResult = new TravelResult(4, LocalDate.parse("2021-06-07"), new ArrayList<>(
                Arrays.asList(new MandatoryItem(MandatoryItemType.MUG, 2),
                        new MandatoryItem(MandatoryItemType.POT, 2),
                        new MandatoryItem(MandatoryItemType.MRE, 8),
                        new MandatoryItem(MandatoryItemType.LIGHTER, 2),
                        new MandatoryItem(MandatoryItemType.WATER_BOTTLE, 2),
                        new MandatoryItem(MandatoryItemType.TENT, 2),
                        new MandatoryItem(MandatoryItemType.WATER_FILTERING_KIT, 2),
                        new MandatoryItem(MandatoryItemType.SLEEPING_BAG, 2),
                        new MandatoryItem(MandatoryItemType.SLEEPING_MAT, 2)

        )));

        TravelResult result = travelService.getTravelHelperResult(100d, 2, LocalDate.parse("2021-06-04"));

        assertEquals(expectedResult.getDaysCount(), result.getDaysCount());
        assertEquals(expectedResult.getEndDate(), result.getEndDate());
        assertEquals(expectedResult.getMandatoryItemList().toString(), result.getMandatoryItemList().toString());

    }

    @Test
    public void testGetWinterItems() {
        TravelResult expectedResult = new TravelResult(4, LocalDate.parse("2021-12-07"), new ArrayList<>(
                Arrays.asList(new MandatoryItem(MandatoryItemType.MUG, 2),
                        new MandatoryItem(MandatoryItemType.POT, 2),
                        new MandatoryItem(MandatoryItemType.MRE, 8),
                        new MandatoryItem(MandatoryItemType.LIGHTER, 2),
                        new MandatoryItem(MandatoryItemType.WATER_BOTTLE, 2),
                        new MandatoryItem(MandatoryItemType.TENT, 2),
                        new MandatoryItem(MandatoryItemType.WATER_FILTERING_KIT, 2),
                        new MandatoryItem(MandatoryItemType.WINTER_SLEEPING_BAG, 2),
                        new MandatoryItem(MandatoryItemType.WINTER_SLEEPING_MAT, 2)

                )));

        TravelResult result = travelService.getTravelHelperResult(100d, 2, LocalDate.parse("2021-12-04"));

        assertEquals(expectedResult.getDaysCount(), result.getDaysCount());
        assertEquals(expectedResult.getEndDate(), result.getEndDate());
        assertEquals(expectedResult.getMandatoryItemList().toString(), result.getMandatoryItemList().toString());

    }

    @Test
    public void testGetLessThanOneDayItems() {
        TravelResult expectedResult = new TravelResult(1, LocalDate.parse("2021-06-04"), new ArrayList<>(
                Arrays.asList(new MandatoryItem(MandatoryItemType.MUG, 2),
                        new MandatoryItem(MandatoryItemType.POT, 2),
                        new MandatoryItem(MandatoryItemType.MRE, 2),
                        new MandatoryItem(MandatoryItemType.LIGHTER, 2),
                        new MandatoryItem(MandatoryItemType.WATER_BOTTLE, 2)
                )));

        TravelResult result = travelService.getTravelHelperResult(12.5, 2, LocalDate.parse("2021-06-04"));

        assertEquals(expectedResult.getDaysCount(), result.getDaysCount());
        assertEquals(expectedResult.getEndDate(), result.getEndDate());
        assertEquals(expectedResult.getMandatoryItemList().toString(), result.getMandatoryItemList().toString());

    }
}
