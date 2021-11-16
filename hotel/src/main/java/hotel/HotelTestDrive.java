/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;



import java.util.*;
import java.io.*;

public class HotelTestDrive {
    
    Room_Info [] a = new Room_Info [100];
    
    void A_room () {    // 방 생성하는 메서드
    
    Room_Info p;
   
    int count = 1;
        
    for(int i=0; i< 100; i++) {   
        a[i] = new Room_Info();
        a[i].R_Num = i+1;
    }    
        for(int i=0; i<100; i = i+10){
        
            for(int j=0; j<10; j++){
            
                if(j<6){    // 스탠다드 룸
                    a[i+j].Standard_Room();
                }
                else if(j>=6 && j<9){   // 스위트 룸
                    a[i+j].Sweet_Room();
                }
                else{   // 파티 룸
                    a[i+j].Party_Room();
                }
                
            }
        
        }
    
   
   }
    
    
    
    public void reservation() throws IOException{   // 예약 입력/삭제/목록
        
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        
        int rooms = 0;
        int operation = 0;


        while (operation != 4) // 4를 입력할때까지 무한반복
        {
            System.out.println("===============================================================");
            System.out.println("<< 1.예약 입력    2.예약 삭제   3.예약 목록    4.예약 종료  5.음식 주문 >>");
            System.out.println("===============================================================");
            
            String operation_q = is.readLine();
            operation = Integer.parseInt(operation_q);
            
            switch(operation)
            {
                // 예약 입력
                case 1:
                    System.out.println("입실할 호실을 입력하세요. (1~n)");
                    
                    String forRoom = is.readLine();
                    
                    int fornumOfRoom = Integer.parseInt(forRoom);
                    int C_RNum = fornumOfRoom;
                    
                    if(a[C_RNum-1].checkInOut == false){  // 객실 상태 확인
                        
                        int number;
                        
                        System.out.println("고객의 총 인원 수를 입력하세요.");
                        forRoom = is.readLine();
                        number = Integer.parseInt(forRoom);
                        int C_Num = number;
                       
                        if(a[C_RNum-1].Room_Num < C_Num){   // 각 방 default 인원수 검사
                            System.out.println("인원수 초과 입니다. 다시 입력해주세요");
                            break;
                        }

                        
                        System.out.println("고객 성함을 입력하세요.");
                        forRoom = is.readLine();
                       
                        String C_name = forRoom;
                       
                        System.out.println("고객 전화번호를 입력하세요.");
                        forRoom = is.readLine();
                        String C_PNum = forRoom;
                       
                        System.out.println(C_name + "고객님. " + C_RNum + " 호실, " + C_PNum + ", " + C_Num + "명 예약이 완료되었습니다.");
                        
                    
                        // 입력한 값 넣는 곳
                        a[C_RNum-1].UserName = C_name; // 이름 넣기
                        a[C_RNum-1].UserPhone = C_PNum; // 전화번호 
                        a[C_RNum-1].insert_Num = C_Num;  // 예약한 고객 수
                        a[C_RNum-1].checkInOut = true;  // 체크인 상태
                 
                        break;
                    }
                    else{
                        System.out.println("이미 방이 예약되어있습니다.");
                        break;
                    }
                    
                    
                    
                // 예약 삭제
                case 2:
                   System.out.println("퇴실할 호실을 입력하세요.");
                   forRoom = is.readLine();
                   fornumOfRoom = Integer.parseInt(forRoom);
                    
                   if(a[fornumOfRoom-1].checkInOut == true)
                   {
                       System.out.println(fornumOfRoom + "호실, 퇴실 완료되었습니다.");
                        a[fornumOfRoom-1].UserName = null; // 이름 넣기
                        a[fornumOfRoom-1].UserPhone = null; // 전화번호 
                        a[fornumOfRoom-1].insert_Num = 0;  // 예약한 고객 수
                        a[fornumOfRoom-1].checkInOut = false;  // 체크인 상태    
                        break;
                   }
                   else
                   {
                       System.out.println(fornumOfRoom + " 호실은 비어있습니다.");
                       break;
                   }
                   
                   
                // 예약 목록   
                case 3:
                    for(int i = 0; i<100; i++){
                        a[i].Room_Information();
                    }
                    break;
                    
                case 4:
                    System.out.println("예약이 종료되었습니다.");
                    break;
                
                    
                // 음식 관련    
                case 5:
                    Menu menu = new Menu();
                    
                    System.out.println("=================================");
                    System.out.println("<< 1. 스태프        2. 관리자 >>");
                    System.out.println("=================================");
            
                    String p = is.readLine();
                    operation = Integer.parseInt(p);
                    
                    if(operation == 1){
                        menu.staffMenu();
                    }
                    else if(operation == 2){
                        menu.manageMenu();
                    }
                    else{
                        break;
                    }
                    
                default:
                    System.out.println("다시 입력해주십시요.");
                    operation = 0;
                    break;
            }
        }
    }

}

