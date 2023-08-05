package com.example.asm.view.main.dto;

import com.example.asm.view.main.model.ServiceComplete;

import java.util.List;

public class GetAllServiceCompleteResponseDTO {

    private String status;
    private List<ServiceComplete> service_complete;

    public GetAllServiceCompleteResponseDTO() {
    }

    public GetAllServiceCompleteResponseDTO(String status, List<ServiceComplete> list) {
        this.status = status;
        this.service_complete = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ServiceComplete> getList() {
        return service_complete;
    }

    public void setList(List<ServiceComplete> list) {
        this.service_complete = list;
    }
}
