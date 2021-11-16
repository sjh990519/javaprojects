/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author kimkyeonghyun
 */
public class Room_Info {
    
    String Room_Type;   // 객실 타입
    int Room_Num;   // 인원수   
    int Room_Pay;   // 방 가격
    int R_Num; // 방 번호
    String UserName;   //고객 이름
    String UserPhone;   // 폰 번호
    int insert_Num;  // 예약한 고객 수인
    String pay_st;  // 결제 상태
    boolean checkInOut = false; // 체크 인/아웃
    int all_pay = 0;    // 총 비용

    
    void all_pay(){ // 총 가격 계산
    
        all_pay = Room_Pay;
        System.out.println("총 비용 : " + all_pay);
    }
    
    
    public Room_Info(){}
   
    // 방 기본 정보
    public Room_Info(String Room_Type, int Room_Num, int Room_Pay){ 
    
        this.Room_Type = Room_Type; // 객실 타입
        this.Room_Num = Room_Num;   // 객실 번호
        this.Room_Pay = Room_Pay;   // 객실 가격
        
    }
    
    // 스텐다드룸 정보
    void Standard_Room(){
        
        this.Room_Type = "Standard Room";
        this.Room_Num = 2;
        this.Room_Pay = 150000;
      
    }
    
    
    // 스위트룸 정보
    void Sweet_Room(){

        this.Room_Type = "Sweet Room";
        this.Room_Num  = 5;
        this.Room_Pay = 300000;
        
        
    }
    
    
    // 파티룸 정보
    void Party_Room(){
        
        this.Room_Type = "Party Room";
        this.Room_Num = 8;
        this.Room_Pay = 75000;
        
    }

    // 현재 방 정보
    void Room_Information(){
        
        RoomInfo k = new RoomInfo();
        
        
        System.out.println("================================================");
        System.out.println("");
        System.out.println("방 번호 : " + R_Num);
        System.out.println("");
        System.out.println("[방 현황]");
        System.out.println("체크인 상태 : " + checkInOut);
        System.out.println("고객 이름 : " + UserName);
        System.out.println("전화번호 : " + UserPhone);
        System.out.println("객실 타입 : " + Room_Type);
        System.out.println("인원수 : " + insert_Num + "/" + Room_Num);
        
        System.out.println("");
        System.out.println("[청구서]");
        System.out.println("객실 비용 : " + Room_Pay);
        System.out.println("결제 방법 : " + pay_st);
        System.out.println("식사 비용 : ");
        all_pay();  // 총 가격
        System.out.println("");
        System.out.println("================================================");
        System.out.println("");
       
    }
   
}

