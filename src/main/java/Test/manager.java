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
/*
    
   System_User_List 메니저 테이블 추가 수정 삭제 할 시 필요한 클래스

    ArrayList 사용시 무조건 필요합니다.
    
*/
public class manager {

    public manager(){}
    
    
    private String id;
    private String pw;
    
   public manager(String id, String pw){
       this.id = id;
       this.pw = pw;
   }
   
   // 메니저 ID getter
    public String getID(){
       return id;
   }
   
    // 메니저 PW getter
   public String getPW(){
       return pw;
   }
    
    
    
}
