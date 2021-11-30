/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelServer {

    BufferedReader in;
    PrintWriter out;
    static ServerSocket server;
    Socket socket;
    static Scanner scanner;
    static Scanner text;
    static String RadioCheck = "Manager";
    static String Operation = "Failed"; //정적, 로그인 성공여부 (초기값은 Failed, 클라이언트에 로그인 성공 시, Success 값 전달)
    static String received_ID; //클라이언트로부터 받은 ID 값 저장할 변수
    static String received_PW; //클라이언트로부터 받은 PW값 저장할 변수
    static String compare_IDCheck; //Scan을 통해 텍스트에서 첫번째문장을 읽어낼 아이디문장
    static String compare_PWCheck; //Scan을 통해 텍스트에서 두번째 문장을 읽어낼 비번문장
    static String ip;
    static String testing;
    File s_file = new File("s_login_info.txt"); //직원 로그인 파일
    File m_file = new File("m_login_info.txt"); //매니저 로그인 파일

    public HotelServer(int port) { //서버 클래스 생성자
        try {
            server = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void waitforClient() { //클라이언트의 접속 승인 메소드
        System.out.println("--------------------------");
        System.out.println("클라이언트의 접속을 기다린다. (accept())");
        System.out.println("--------------------------");

        try {
            socket = server.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void Check() throws FileNotFoundException, IOException { //Scan하여 나온 IDCheck와 PWCheck를 
        //클라이언트로부터 받은 ID , PW를 비교하여 Operation 값 변화(Static 무조건 쓰여야 작동함.)

        if (RadioCheck.equals("Staff")) {
            scanner = new Scanner(new File("s_login_info.txt"));
        } else {
            scanner = new Scanner(new File("m_login_info.txt"));
        }

        while (scanner.hasNext()) {
            testing = scanner.nextLine();
            text = new Scanner(testing).useDelimiter("/");
            compare_IDCheck = text.next();
            System.out.println(compare_IDCheck);
            compare_PWCheck = text.next();
            System.out.println(compare_PWCheck);
            if (received_ID.equals(compare_IDCheck) && received_PW.equals(compare_PWCheck)) {
                //kkh6645 , s1031645
                Operation = "Success"; //ID, PW가 맞다면 성공으로 저장한다.
            }
        }

    }

    public void receive() { //스트림에 속해있는 값인 Staff or Manager( from Client ) 를 읽어내고 클라이언트로부터 받아 저장한다.
        try {
            RadioCheck = in.readLine();
            System.out.println("--------------------------");
            System.out.println("클라이언트로부터 받은 라디오값");
            System.out.println("[클라이언트]  ID  : " + RadioCheck);
            System.out.println("--------------------------\n");

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void receive_ID() { //스트림에 속해있는 값인 ID( from Client ) 를 읽어내고 compare_ID(클라이언트로부터 받은 ID)에 저장한다.
        try {
            received_ID = in.readLine();
            System.out.println("\n--------------------------");
            System.out.println("클라이언트로부터 받은 로그인값");
            System.out.println("[클라이언트]  ID  : " + received_ID + "\n");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void receive_PW() {//스트림에 속해있는 값인 PW( from Client ) 를 읽어내고 compare_PW(클라이언트로부터 받은 PW)에 저장한다.
        try {
            received_PW = in.readLine();
            System.out.println("[클라이언트]  PW  : " + received_PW);
            System.out.println("--------------------------\n");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void send(String msg) { //Operation값을 전달하기 위한 메소드
        out.println(msg);
        out.flush();
    }

    private String getServerIp() {

        InetAddress local = null;
        try {
            local = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("error");
        }

        if (local == null) {
            return "";
        } else {
            ip = local.getHostAddress();
            return ip;
        }
    }

    public static void main(String[] args) throws IOException {

        HotelServer HotelServer = new HotelServer(9999);
        while (true) {
            HotelServer.waitforClient(); //클라이언트의 접속을 기다린다. (accept())
            System.out.println("\n--------------------------");
            System.out.println("클라이언트 <-> 서버 접속 완료."); //접속 확인 출력
            HotelServer.getServerIp();
            System.out.println(ip);
            System.out.println("--------------------------\n");

            while (Operation.equals("Failed")) {
                HotelServer.receive();
                HotelServer.send(RadioCheck);
                HotelServer.receive_ID(); //ID를 받고, (한 번에 ID, PW 두 개의 인자를 받는 것이 안되기 때문에
                //밑의 문장, send("a"); 와 같이 한 번 흐름을 끊었음.
                HotelServer.send("a");
                HotelServer.receive_PW(); //PW를 받고,
                HotelServer.Check();//받은 ID와 PW를 도합 검사한 뒤에, 성공여부(Operation)를 저장한 후,
                HotelServer.send(HotelServer.Operation); //클라이언트에 성공 여부를 전달해준다.
                //성공여부 Operation의 기본값은 Failed / 로그인 성공시 Success 로 바뀐다.
            }
//            server.close();
            Operation = "Failed";
        }

//        
    }

}
