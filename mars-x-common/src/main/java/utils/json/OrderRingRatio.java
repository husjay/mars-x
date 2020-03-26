package utils.json;

import com.alibaba.excel.util.DateUtils;
import com.alibaba.fastjson.JSON;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import utils.StringUtils;
import utils.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderRingRatio {

    public static void main(String[] args) throws ParseException {
        int count = 72;
        List<OrderStat> yestList = new ArrayList<>();
        List<OrderStat> todayList = new ArrayList<>();
        for(int i=1;i<=72;i++){
            OrderStat stat = new OrderStat();
            stat.setMarket("All");
            String hour = String.valueOf(i/3);
            String minute = String.valueOf((i%3)*20);
            stat.setDate("2019-11-16 " + hour + ":" + minute + ":00");
            System.out.println(stat.getDate());
            stat.setOrderNumber(new Random().nextInt(20) + 5);
            stat.setRoomNights(new Random().nextInt(50));
            stat.setConfirmed(new Random().nextInt(18));
            stat.setPaymentFailed(new Random().nextInt(3));
            stat.setCanceled(new Random().nextInt(3));
            stat.setProcessing(new Random().nextInt(2));
            stat.setHitRisk(new Random().nextInt(2));
            stat.setGmv_rmb(new Random().nextInt(40000));
            stat.setRevenue_rmb(new Random().nextInt(4000));
            yestList.add(stat);
        }

        Calendar now = Calendar.getInstance();
        int todayNumber = (now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE)) / 20 + 1;

        for(int i=1;i<=72;i++){
            OrderStat stat = new OrderStat();
            stat.setMarket("All");
            String hour = String.valueOf(i/3);
            String minute = String.valueOf((i%3)*20);
            stat.setDate("2019-11-17 " + hour + ":" + minute + ":00");
            System.out.println(stat.getDate());
            stat.setOrderNumber(new Random().nextInt(20) + 8);
            stat.setRoomNights(new Random().nextInt(55));
            stat.setConfirmed(new Random().nextInt(20));
            stat.setPaymentFailed(new Random().nextInt(4));
            stat.setCanceled(new Random().nextInt(3));
            stat.setProcessing(new Random().nextInt(1));
            stat.setHitRisk(new Random().nextInt(3));
            stat.setGmv_rmb(new Random().nextInt(50000));
            stat.setRevenue_rmb(new Random().nextInt(5000));
            todayList.add(stat);
        }

        //周
        List<OrderStat> weekList = new ArrayList<>();
        for(int i=1;i<=14;i++){
            OrderStat stat = new OrderStat();
            stat.setMarket("All");
            String day = String.valueOf(2+i);
            stat.setDate("2019-11-"+day);
            System.out.println(stat.getDate());
            stat.setOrderNumber(new Random().nextInt(200) + 500);
            stat.setRoomNights(new Random().nextInt(200) + 1500);
            stat.setConfirmed(new Random().nextInt(20) + 600);
            stat.setPaymentFailed(new Random().nextInt(20) + 60);
            stat.setCanceled(new Random().nextInt(10) + 10);
            stat.setProcessing(new Random().nextInt(3) + 2);
            stat.setHitRisk(new Random().nextInt(3) + 2);
            stat.setGmv_rmb(new Random().nextInt(100000) + 1500000);
            stat.setRevenue_rmb(new Random().nextInt(10000) + 150000);
            weekList.add(stat);
        }

        //月
        Date beginDate = DateUtils.parseDate("2019-08-31");
        List<OrderStat> monthList = new ArrayList<>();
        for(int i=1;i<=61;i++){
            OrderStat stat = new OrderStat();
            stat.setMarket("All");
            stat.setDate(new SimpleDateFormat("yyyy-MM-dd").format(TimeUtils.addDays(beginDate, i)));
            stat.setOrderNumber(new Random().nextInt(200) + 500);
            stat.setRoomNights(new Random().nextInt(200) + 1500);
            stat.setConfirmed(new Random().nextInt(20) + 600);
            stat.setPaymentFailed(new Random().nextInt(20) + 60);
            stat.setCanceled(new Random().nextInt(10) + 10);
            stat.setProcessing(new Random().nextInt(3) + 2);
            stat.setHitRisk(new Random().nextInt(3) + 2);
            stat.setGmv_rmb(new Random().nextInt(100000) + 1500000);
            stat.setRevenue_rmb(new Random().nextInt(10000) + 150000);
            monthList.add(stat);
        }

        String yest = JSON.toJSONString(yestList);
        String today = JSON.toJSONString(todayList);
        System.out.println("---------------------");
        System.out.println("let dayData = {\"orderStatList\":");
        System.out.println(yest.substring(0,yest.length()-1));
        System.out.println(",");
        System.out.println(today.substring(1));
        System.out.println(",\"maxOrderNumber\": 25,\"maxRoomNights\": 1787}");


        System.out.println("let weekData = {\"orderStatList\":");
        System.out.println(JSON.toJSONString(weekList));
        System.out.println(",\"maxOrderNumber\": 800,\"maxRoomNights\": 1787}");


        System.out.println("let monthData = {\"orderStatList\":");
        System.out.println(JSON.toJSONString(monthList));
        System.out.println(",\"maxOrderNumber\": 800,\"maxRoomNights\": 1787}");

    }

    static class OrderStat{
        private String market;
        private String date;
        private Integer orderNumber;
        private Integer roomNights;
        private Integer confirmed;
        private Integer paymentFailed;
        private Integer canceled;
        private Integer processing;
        private Integer hitRisk;
        private Integer gmv_rmb;
        private Integer revenue_rmb;
        private String orderCategoryList;

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(Integer orderNumber) {
            this.orderNumber = orderNumber;
        }

        public Integer getRoomNights() {
            return roomNights;
        }

        public void setRoomNights(Integer roomNights) {
            this.roomNights = roomNights;
        }

        public Integer getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(Integer confirmed) {
            this.confirmed = confirmed;
        }

        public Integer getPaymentFailed() {
            return paymentFailed;
        }

        public void setPaymentFailed(Integer paymentFailed) {
            this.paymentFailed = paymentFailed;
        }

        public Integer getCanceled() {
            return canceled;
        }

        public void setCanceled(Integer canceled) {
            this.canceled = canceled;
        }

        public Integer getProcessing() {
            return processing;
        }

        public void setProcessing(Integer processing) {
            this.processing = processing;
        }

        public Integer getHitRisk() {
            return hitRisk;
        }

        public void setHitRisk(Integer hitRisk) {
            this.hitRisk = hitRisk;
        }

        public Integer getGmv_rmb() {
            return gmv_rmb;
        }

        public void setGmv_rmb(Integer gmv_rmb) {
            this.gmv_rmb = gmv_rmb;
        }

        public Integer getRevenue_rmb() {
            return revenue_rmb;
        }

        public void setRevenue_rmb(Integer revenue_rmb) {
            this.revenue_rmb = revenue_rmb;
        }

        public String getOrderCategoryList() {
            return orderCategoryList;
        }

        public void setOrderCategoryList(String orderCategoryList) {
            this.orderCategoryList = orderCategoryList;
        }
    }


}
