package com.mars.x.dto;

/**
 * @author: sj.hu
 * @date: 2020/2/18 11:21
 **/
public class BookingStatusDto {
    private String scBookingId;
    private String partnerBookingId;
    private String orderStatus;
    private String orderStatusDesc;

    public String getScBookingId() {
        return scBookingId;
    }

    public void setScBookingId(String scBookingId) {
        this.scBookingId = scBookingId;
    }

    public String getPartnerBookingId() {
        return partnerBookingId;
    }

    public void setPartnerBookingId(String partnerBookingId) {
        this.partnerBookingId = partnerBookingId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusDesc() {
        return orderStatusDesc;
    }

    public void setOrderStatusDesc(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }
}
