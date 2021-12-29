package com.travel.helper.model;

import java.time.LocalDate;
import java.util.List;

public class TravelResult {
    private Integer daysCount;
    private LocalDate endDate;
    private List<MandatoryItem> mandatoryItemList;

    public TravelResult(Integer daysCount, LocalDate endDate, List<MandatoryItem> mandatoryItemList) {
        this.daysCount = daysCount;
        this.endDate = endDate;
        this.mandatoryItemList = mandatoryItemList;
    }

    public Integer getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(Integer daysCount) {
        this.daysCount = daysCount;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<MandatoryItem> getMandatoryItemList() {
        return mandatoryItemList;
    }

    public void setMandatoryItemList(List<MandatoryItem> mandatoryItemList) {
        this.mandatoryItemList = mandatoryItemList;
    }
}
