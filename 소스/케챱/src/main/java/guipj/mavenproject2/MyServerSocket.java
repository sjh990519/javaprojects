/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipj.mavenproject2;

import java.io.*;
import java.util.*;
import java.net.*;



/**
 *
 * @author 이주혁
 */
public class MyServerSocket {

    int port = 9999;
    ServerSocket server;
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public MyServerSocket( int port) {
        try {
            server = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public void waitforClient()
    {
//        System.out.println(">> 클라이언트가 접속하길 기다리고 있습니다. ");
        try {
            socket = server.accept();
            printInfo();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public void receive()
    {
        try {
            System.out.println("[클라이언트] "+in.readLine());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public void send(String msg)
    {
        out.println(msg);
        out.flush();
        System.out.println("[서버] "+ msg);
    }
    
    public void close()
    {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    
    public void printInfo()
    {
        System.out.println(">> 클라이언트가 접속에 성공했습니다.");
        System.out.println("        서버 주소 : "+ socket.getInetAddress());
        System.out.println("        클라이언트 주소 : "+socket.getPort());
        System.out.println("        클라이언트 포트번호 : "+ socket.getLocalPort()+ "\n\n");
    }
    
    public static void main(String[] args) {
        int port =9999;
        MyServerSocket myServer = new MyServerSocket(port);
        myServer.waitforClient();
        myServer.receive();
        myServer.send("서버에 접속하신걸 환영합니다.");
        myServer.close();
    }
}
