/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author 916
 */
public class guest_list {
    
    // 방 번호
    String roomN;
    // 이름
    String name;
    // 전화번호
    String phone;
    // 인원 수
    String user;
    // 체크인 일정
    String checkin_day;
    // 체크인 시간
    String checkin_time;
    // 체크아웃 일정
    String checkout_day;
    // 체크아웃 시간
    String checkout_time;
    // 결제 방법
    String pay;
    // 체크인 상태
    String checkin_status;
    
    
    
    public guest_list(){}
    
    
    
    public guest_list(String roomN, String name, String phone, String user, String checkin_day, String checkin_time, String checkout_day, String checkout_time, String pay, String checkin_status){
    
        this.roomN = roomN;
        this.name = name;
        this.phone = phone;
        this.user = user;
        this.checkin_day = checkin_day; 
        this.checkin_time = checkin_time;
        this.checkout_day = checkout_day; 
        this.checkout_time = checkout_time;
        this.pay = pay;
        this.checkin_status = checkin_status;
        
    }

    public String getRoomN() {
        return roomN;
    }

    public void setRoomN(String roomN) {
        this.roomN = roomN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCheckin_day() {
        return checkin_day;
    }

    public void setCheckin_day(String checkin_day) {
        this.checkin_day = checkin_day;
    }

    public String getCheckin_time() {
        return checkin_time;
    }

    public void setCheckin_time(String checkin_time) {
        this.checkin_time = checkin_time;
    }

    public String getCheckout_day() {
        return checkout_day;
    }

    public void setCheckout_day(String checkout_day) {
        this.checkout_day = checkout_day;
    }

    public String getCheckout_time() {
        return checkout_time;
    }

    public void setCheckout_time(String checkout_time) {
        this.checkout_time = checkout_time;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getCheckin_status() {
        return checkin_status;
    }

    public void setCheckin_status(String checkin_status) {
        this.checkin_status = checkin_status;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}