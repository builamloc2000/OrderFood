package com.example.order_service.application.dto.request;

import java.util.Date;

public class OrderUpdateStatusRequestDTO {
    private Long statusId;
    private Date timeFinish;

    public Long getStatusId() {
        return statusId;
    }

    public Date getTimeFinish() {
        return timeFinish;
    }
}
