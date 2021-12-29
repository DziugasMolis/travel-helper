package com.travel.helper.service;

import com.travel.helper.model.MandatoryItem;
import com.travel.helper.model.MandatoryItemType;
import com.travel.helper.model.Season;
import com.travel.helper.model.TravelResult;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    int PER_DAY = 25;

    @Override
    public TravelResult getTravelHelperResult(Double length, Integer travellers, LocalDate startDate) {
        int daysCount = (int) Math.ceil(length / PER_DAY);
        LocalDate endDate = startDate.plusDays(daysCount);
        List<MandatoryItem> mandatoryItemList = getMandatoryItems(daysCount, travellers, startDate, endDate);
        return new TravelResult(daysCount, endDate, mandatoryItemList);
    }

    private List<MandatoryItem> getMandatoryItems(int daysCount, Integer travellers, LocalDate startDate, LocalDate endDate) {
        List<MandatoryItem> mandatoryItemList = new ArrayList<>(Arrays.asList(new MandatoryItem(MandatoryItemType.MUG, travellers), new MandatoryItem(MandatoryItemType.POT, travellers), new MandatoryItem(MandatoryItemType.MRE, daysCount), new MandatoryItem(MandatoryItemType.LIGHTER, travellers), new MandatoryItem(MandatoryItemType.WATER_BOTTLE, travellers)));

        if (daysCount > 1) {
            mandatoryItemList.add(new MandatoryItem(MandatoryItemType.TENT, travellers));
            mandatoryItemList.add(new MandatoryItem(MandatoryItemType.WATER_FILTERING_KIT, travellers));
        }

        mandatoryItemList.addAll(getSeasonalMandatoryItems(travellers, startDate, endDate));
        return mandatoryItemList;
    }

    private List<MandatoryItem> getSeasonalMandatoryItems(Integer travellers, LocalDate startDate, LocalDate endDate) {
        Season startSeason = Season.of(startDate.getMonth());
        Season endSeason = Season.of(endDate.getMonth());
        if (startSeason == Season.WINTER || endSeason == Season.WINTER) {
            return new ArrayList<>(List.of(new MandatoryItem(MandatoryItemType.WINTER_SLEEPING_BAG, travellers), new MandatoryItem(MandatoryItemType.WINTER_SLEEPING_MAT, travellers)));
        }
        return new ArrayList<>(List.of(new MandatoryItem(MandatoryItemType.SLEEPING_BAG, travellers), new MandatoryItem(MandatoryItemType.SLEEPING_MAT, travellers)));
    }
}
