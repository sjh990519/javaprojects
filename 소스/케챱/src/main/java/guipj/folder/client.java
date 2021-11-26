/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipj.folder;

import java.util.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public client(String ip, int port) {
      
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    public static void main(String[] args)  {
        
        System.out.println("서버에게 보낼 메시지 입력 >> ");
        Scanner ss = new Scanner(System.in);
        
        
    }

}
