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
    
    
    
    public guest_list(String roomN, String name, String phone, String user, String checkin_time, String checkout_time, String pay){
    
        this.roomN = roomN;
        this.name = name;
        this.phone = phone;
        this.user = user;
        this.checkin_time = checkin_time;
        this.checkout_time = checkout_time;
        this.pay = pay;

    }
    
    
    // 방 번호 getter
    public String getroomN(){
        return roomN;
    }
    
    // 이름 getter
    public String getname(){
        return name;
    }
    
    // 전화번호 getter
    public String getphone(){
        return phone;
    }
    
    // 인원 수 getter
    public String getuser(){
        return user;
    }
    
    // 체크인 시간 getter
    public String getcheckin_time(){
        return checkin_time;
    }
    
     // 체크아웃 시간 getter
    public String getcheckout_time(){
        return checkout_time;
    }
    
    // 결제 방법 getter
    public String getpay(){
        return pay;
    }
    
    
}
