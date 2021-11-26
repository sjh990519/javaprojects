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
public class manager {

    public manager(){}
    
    
    private String id;
    private String pw;
    
   public manager(String id, String pw){
       this.id = id;
       this.pw = pw;
   }
   
    public String getID(){
       return id;
   }
   
   public String getPW(){
       return pw;
   }
    
    
    
}
