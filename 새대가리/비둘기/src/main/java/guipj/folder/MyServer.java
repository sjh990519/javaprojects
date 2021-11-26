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

public class MyServer {

    BufferedReader in;
    PrintWriter out;
    ServerSocket server;
    Socket socket;
    static String Operation = "Failed";
    static String compare_ID;
    static String compare_PW;
    static String compare_IDCheck;
    static String compare_PWCheck;
    File s_file = new File("s_login_info.txt");
    File m_file = new File("m_login_info.txt");

    public MyServer(int port) {
        try {
            server = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void waitforClient() {

        try {
            socket = server.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void Check() throws FileNotFoundException, IOException {

        Scanner scanner = new Scanner(new File("s_login_info.txt"));

        compare_IDCheck = scanner.next();
        scanner.hasNext();
        compare_PWCheck = scanner.next();
        
        System.out.println(compare_IDCheck);
        System.out.println(compare_PWCheck);
        
        if (compare_ID.equals(compare_IDCheck) && compare_PW.equals(compare_PWCheck)) {
            //kkh6645 , s1031645
            Operation = "Success";
        }
    }

    public void receive_ID() {
        try {
            compare_ID = in.readLine();
            System.out.println("[클라이언트] " + compare_ID);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void receive_PW() {
        try {
            compare_PW = in.readLine();
            System.out.println("[클라이언트] " + compare_PW);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void send(String msg) {
        out.println(msg);
        out.flush();
        System.out.println("[서버] " + msg);
    }

    public static void main(String[] args) throws IOException {

        MyServer HotelServer = new MyServer(9999);
//        ServerSocket MyServer = new ServerSocket(9999);
//        Socket s = MyServer.accept();
        HotelServer.waitforClient();
        System.out.println("클라이언트 <-> 서버 접속 완료.");
        HotelServer.receive_ID();
        HotelServer.send("a");
        HotelServer.receive_PW();
        HotelServer.Check();
        HotelServer.send(MyServer.Operation);

//        
    }

}
