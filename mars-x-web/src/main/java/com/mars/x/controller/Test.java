package com.mars.x.controller;

import com.mars.x.dto.BookingStatusDto;
import com.mars.x.vo.BookingStatusVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author: sj.hu
 * @date: 2020/2/18 10:42
 **/
@RestController
@RequestMapping("/booking")
public class Test {

    @PutMapping("/status")
    public Object listSearch(@RequestBody BookingStatusDto dto, HttpServletRequest request) {
        System.out.println(dto.getScBookingId());
        System.out.println(dto.getPartnerBookingId());
        System.out.println(dto.getOrderStatus());
        System.out.println(dto.getOrderStatusDesc());

        System.out.println(request.getQueryString());

        BookingStatusVo vo = new BookingStatusVo();
        vo.setMessage("Put Success");
        return vo;
    }

}
