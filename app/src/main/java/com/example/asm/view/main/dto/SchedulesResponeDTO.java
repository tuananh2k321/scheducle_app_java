package com.example.asm.view.main.dto;

import com.example.asm.view.main.model.Schedules;

import java.util.List;

public class SchedulesResponeDTO {
    private Boolean status;
    private List<Schedules> data;

    public SchedulesResponeDTO() {
    }

    public SchedulesResponeDTO(Boolean status, List<Schedules> data) {
        this.status = status;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Schedules> getData() {
        return data;
    }

    public void setData(List<Schedules> data) {
        this.data = data;
    }
}
