/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.io.IOException;

/**
 *
 * @author kimkyeonghyun
 */
public class TestDrive {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        Room_Info info = new Room_Info();
        
        //q.A_room();
        
        HotelTestDrive me = new HotelTestDrive();
        
        me.A_room();    // 방 생성
        me.reservation();    // 예약
        
        
    }
    
}
