/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;

/**
 *
 * @author 916
 */
/*

   System_User_List 직원 테이블 추가 수정 삭제 할 시 필요한 클래스

    ArrayList 사용시 무조건 필요합니다.

*/
public class staff {
    
    private String id;
    private String pw;
   
   public staff(){}
    
    
   public staff(String id, String pw){
       this.id = id;
       this.pw = pw;
   }

   // 직원 ID getter
   public String getID(){
       return id;
   }
   
   // 직원 PW getter
   public String getPW(){
       return pw;
   }
   


    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    
    
}
