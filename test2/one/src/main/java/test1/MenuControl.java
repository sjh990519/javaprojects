/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author me
 */
public class MenuControl extends javax.swing.JFrame {

    String[] key = null; //음식종류의 음식명을 배열에 담음 //ex)[음료, 콜라, 1000, 15]
    String[] str2 = new String[100];// 음식명 담는 배열  최대100개 //ex)[콜라, 사이다,밀키스,마운틴듀,부산우유]
    int count = 1;// 행의 길이에따라 jComboBox_FoodName 길이를 증가시키기위해서 

    /**
     * Creates new form MenuControl
     */
    // ShowMenu(int index)에서 index가 0일때 메뉴판을 초기화시킴
    public void Order() {
        DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
        table.setNumRows(0);// 테이블 초기화
    }

    //ShowMenu(int index)에서 index(1~5)에따라 해당 메뉴판을 jTable에 출력함
    public void Order(String str) {

        File menu_file = new File(str);//str값에 따라 텍스트파일 생성

        try {

            BufferedReader filereader = new BufferedReader(new InputStreamReader(new FileInputStream(menu_file), "UTF8"));//파일읽기

            DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
            table.setNumRows(0);// 테이블 초기화

            String line;
            String[] key;
            count = 0;// 행 길이

            // 한 행씩 읽어서 한 행씩 테이블에 저장
            while ((line = filereader.readLine()) != null) {
                key = line.split("/");
                Object[] list = {key[0], key[1], key[2], key[3]};
                str2[count] = key[1];// ex) 음식종류 -> 음료 일때 str2[count] = {"콜라", "사이다","밀키스","마운틴듀","부산우유"};
                table.addRow(list); // 메뉴판에 각각의 음식 행을 출력!
                count++;// 행의 길이에따라 count값 증가
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // 음식종류를 클릭하면 그에맞는 음식명을 jComboBox_FoodName에 표시하는 함수!
    public String[] getStr() {
        String[] str3 = new String[count];//count의 크기에따라 str3 객체 생성
        for (int i = 0; i < count; i++) {
            str3[i] = str2[i];
        }
        return str3;
    }

    //음식종류 콤보박스에 따라 호출되는 함수!
    public void ShowMenu(int index) {

        int num = jComboBox_Option.getSelectedIndex();//옵션 콤보박스 인덱스 리턴

        switch (index) {

            case 0://선택안함
                jLabel_Msg.setText("");//공백으로 초기화

                jLabel_MenuName.setText("음식종류를 선택해 메뉴판을 불러주세요");
                jTextField_Amount.setText("입력불가");
                jTextField_Price.setText("입력불가");
                jTextField_FoodName.setText("입력불가");

                jTextField_Amount.setEnabled(false);//수량 텍스트비활성화
                jTextField_Price.setEnabled(false);//가격 텍스트비활성화
                jTextField_FoodName.setEnabled(false);// 음식명텍스트 비활성화
                jCheckBox_Amount.setSelected(false);//수량 텍스트체크해체
                jCheckBox_Price.setSelected(false);//가격 텍스트체크해체

                Order();// 테이블 초기화 함수

                //음식명 콤보박스 ---으로 초기화
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"---"}));

                break;
            case 1:// 음료

                jLabel_Msg.setText("");//공백으로 초기화
                jLabel_MenuName.setText("음료 메뉴판!");

                if (num == 1) { // 옵션 -> 추가 선택시

                    jTextField_Amount.setText(""); //수량 텍스트 필드 공백으로 초기화
                    jTextField_Price.setText("");//가격 텍스트 필드 공백으로 초기화
                    jTextField_FoodName.setText("");//음식명 텍스트 필드 공백으로 초기화

                    jTextField_Amount.setEnabled(true); //수량 텍스트 필드 활성화
                    jTextField_Price.setEnabled(true);//가격 텍스트 필드 활성화
                    jTextField_FoodName.setEnabled(true);//음식명 텍스트 필드 활성화
                }
                Order("drinkMenu.txt");//음료 메뉴판으로 초기화

                // 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));

                break;
            case 2:// 면류
                jLabel_Msg.setText("");//공백으로 초기화
                if (num == 1) { // 옵션 -> 추가 선택시

                    jTextField_Amount.setText(""); //수량 텍스트 필드 공백으로 초기화
                    jTextField_Price.setText("");//가격 텍스트 필드 공백으로 초기화
                    jTextField_FoodName.setText("");//음식명 텍스트 필드 공백으로 초기화

                    jTextField_Amount.setEnabled(true); //수량 텍스트 필드 활성화
                    jTextField_Price.setEnabled(true);//가격 텍스트 필드 활성화
                    jTextField_FoodName.setEnabled(true);//음식명 텍스트 필드 활성화
                }
                jLabel_MenuName.setText("면류 메뉴판!");
                Order("noodleMenu.txt");//면류 메뉴판을 부르기

                // 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));
                break;
            case 3:// 밥류
                jLabel_Msg.setText("");//공백으로 초기화

                if (num == 1) { // 옵션 -> 추가 선택시

                    jTextField_Amount.setText(""); //수량 텍스트 필드 공백으로 초기화
                    jTextField_Price.setText("");//가격 텍스트 필드 공백으로 초기화
                    jTextField_FoodName.setText("");//음식명 텍스트 필드 공백으로 초기화

                    jTextField_Amount.setEnabled(true); //수량 텍스트 필드 활성화
                    jTextField_Price.setEnabled(true);//가격 텍스트 필드 활성화
                    jTextField_FoodName.setEnabled(true);//음식명 텍스트 필드 활성화
                }
                jLabel_MenuName.setText("밥류 메뉴판!");
                Order("riceMenu.txt");//밥류 메뉴판을 부르기

                // 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));

                break;
            case 4:// 주류
                jLabel_Msg.setText("");//공백으로 초기화
                if (num == 1) { // 옵션 -> 추가 선택시

                    jTextField_Amount.setText(""); //수량 텍스트 필드 공백으로 초기화
                    jTextField_Price.setText("");//가격 텍스트 필드 공백으로 초기화
                    jTextField_FoodName.setText("");//음식명 텍스트 필드 공백으로 초기화

                    jTextField_Amount.setEnabled(true); //수량 텍스트 필드 활성화
                    jTextField_Price.setEnabled(true);//가격 텍스트 필드 활성화
                    jTextField_FoodName.setEnabled(true);//음식명 텍스트 필드 활성화
                }
                jLabel_MenuName.setText("주류 메뉴판!");
                Order("alcolMenu.txt");//주류 메뉴판을 부르기

                // 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));
                break;
            case 5:// 치킨류
                jLabel_Msg.setText("");//공백으로 초기화
                if (num == 1) { // 옵션 -> 추가 선택시

                    jTextField_Amount.setText(""); //수량 텍스트 필드 공백으로 초기화
                    jTextField_Price.setText("");//가격 텍스트 필드 공백으로 초기화
                    jTextField_FoodName.setText("");//음식명 텍스트 필드 공백으로 초기화

                    jTextField_Amount.setEnabled(true); //수량 텍스트 필드 활성화
                    jTextField_Price.setEnabled(true);//가격 텍스트 필드 활성화
                    jTextField_FoodName.setEnabled(true);//음식명 텍스트 필드 활성화
                }
                jLabel_MenuName.setText("치킨류 메뉴판!");
                Order("chickenMenu.txt");//치킨류 메뉴판을 부르기

                // 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));
                break;
        }
    }

    //음식 추가 함수
    public void Add(int FoodSortNum, String FoodName, int price, int amount) {
        String[] str = {"", "drinkMenu.txt", "noodleMenu.txt", "riceMenu.txt", "alcolMenu.txt", "chickenMenu.txt"};
        String[] str3 = {"", "drinkMenu2.txt", "noodleMenu2.txt", "riceMenu2.txt", "alcolMenu2.txt", "chickenMenu2.txt"};
        String[] foodsort = {"", "음료", "면류", "밥류", "주류", "치킨류"};
        String line;
        try {
            DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
            table.setNumRows(0);// 테이블 초기화

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(str[FoodSortNum]), "UTF8"));//1파일읽기

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3[FoodSortNum]), "UTF8"));//2덮어쓰기

            //2파일에 기록하기
            while ((line = br.readLine()) != null) {
                key = line.split("/");//문자열을 자르고 배열로 리턴
                line = String.format("%s/%s/%s/%s", key[0], key[1], key[2], key[3]);//문자열을 쓰기
                bw.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw.flush();
            }
            bw.close();
            br.close();
            //----
            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(str3[FoodSortNum]), "UTF8"));//2읽기모드
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3[FoodSortNum], true), "UTF8"));//2이어쓰기
            //추가하는 음식명, 가격, 수량을 line에 넣음
            boolean isExist = false;// 음식존재한지아닌지
            while ((line = br2.readLine()) != null) {
                key = line.split("/");
                if (key[1].equals(FoodName)) {// 음식이 존재하면
                    jLabel_Msg.setText("이미있음");
                    jLabel_Msg2.setText("");
                    jLabel_Msg3.setText("");
                    isExist = true;
                    break;
                }
            }
            if (isExist == false) {// 음식이 존재안하면
                line = String.format("%s/%s/%s/%s", foodsort[FoodSortNum], FoodName, String.valueOf(price), String.valueOf(amount));
                bw2.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw2.flush();
            }
            bw2.close();
            br2.close();

            //--
            BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(str3[FoodSortNum]), "UTF8"));//2읽기모드
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str[FoodSortNum]), "UTF8"));//1덮어쓰기
            count = 0;
            //1파일에 기록하기
            while ((line = br1.readLine()) != null) {
                bw1.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw1.flush();
                key = line.split("/");
                Object[] list = {key[0], key[1], key[2], key[3]};
                str2[count] = key[1];// ex) 음식종류 -> 음료 일때 str2[count] = {"콜라", "사이다","밀키스","마운틴듀","부산우유"};
                table.addRow(list);//str배열의 텍스트파일의 내용을 메뉴판으로 출력!
                count++;// 행의 길이에따라 count값 증가
            }
            bw1.close();
            br1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));
    }

    //음식 수정 함수
    public void Modify(int FoodSortNum, String FoodName, int amount, int price) {
        String[] str = {"", "drinkMenu.txt", "noodleMenu.txt", "riceMenu.txt", "alcolMenu.txt", "chickenMenu.txt"};
        String[] str3 = {"", "drinkMenu2.txt", "noodleMenu2.txt", "riceMenu2.txt", "alcolMenu2.txt", "chickenMenu2.txt"};

        String line;

        try {
            DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
            table.setNumRows(0);// 테이블 초기화

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(str[FoodSortNum]), "UTF8"));//1파일읽기
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3[FoodSortNum]), "UTF8"));//2덮어쓰기

            //2파일에 기록하기
            while ((line = br.readLine()) != null) {
                key = line.split("/");
                if (key[1].equals(FoodName)) {// line에 FoodName이 있다면
                    key = line.split("/");//문자열을 자르고 배열로 리턴

                    // 가격과 수량이 0라면 =>즉, 입력안받았다면..
                    if (amount == 0 && price == 0) { //아무것도 실행X
                    } else if (amount == 0) {// 수량을 입력안받았다면
                        key[2] = String.valueOf(price);//입력받은 가격으로 수정
                    } else if (price == 0) {// 가격을 입력안받았다면
                        key[3] = String.valueOf(amount);//입력받은 수량으로 수정
                    } else {// 둘다 입력됬다면
                        key[2] = String.valueOf(price);//입력받은 가격으로 수정
                        key[3] = String.valueOf(amount);//입력받은 수량으로 수정
                    }
                    //line에 값을 넣음
                    line = String.format("%s/%s/%s/%s", key[0], key[1], key[2], key[3]);
                }
                bw.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw.flush();
            }
            bw.close();
            br.close();
            //----
            BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(str3[FoodSortNum]), "UTF8"));//2읽기모드
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str[FoodSortNum]), "UTF8"));//1 덮어쓰기
            count = 0;
            while ((line = br3.readLine()) != null) {
                bw2.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw2.flush();
                key = line.split("/");
                Object[] list = {key[0], key[1], key[2], key[3]};
                str2[count] = key[1];// ex) 음식종류 -> 음료 일때 str2[count] = {"콜라", "사이다","밀키스","마운틴듀","부산우유"};
                table.addRow(list);//str배열의 텍스트파일의 내용을 메뉴판으로 출력!
                count++;// 행의 길이에따라 count값 증가
            }
            bw2.close();
            br3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //음식명 콤보박스 초기화
        jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));
    }

    //음식 삭제 함수
    public void Delete(int FoodSortNum, String FoodName) {
        String[] str = {"", "drinkMenu.txt", "noodleMenu.txt", "riceMenu.txt", "alcolMenu.txt", "chickenMenu.txt"};
        String[] str3 = {"", "drinkMenu2.txt", "noodleMenu2.txt", "riceMenu2.txt", "alcolMenu2.txt", "chickenMenu2.txt"};

        String line;
        try {
            DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
            table.setNumRows(0);// 테이블 초기화

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(str[FoodSortNum]), "UTF8"));//1파일읽기
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3[FoodSortNum]), "UTF8"));//2덮어쓰기
            //2파일에 쓰기
            while ((line = br.readLine()) != null) {
                key = line.split("/");
                if (key[1].equals(FoodName)) {// 그행에 음식명이 있다면
                    continue;//다시 반복문으로
                }
                bw.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw.flush();
            }
            bw.close();
            br.close();
            //--
            BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(str3[FoodSortNum]), "UTF8"));//2읽기모드
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str[FoodSortNum]), "UTF8"));//1 덮어쓰기
            count = 0;
            //1파일에 쓰기
            while ((line = br3.readLine()) != null) {
                bw2.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw2.flush();
                key = line.split("/");
                Object[] list = {key[0], key[1], key[2], key[3]};
                str2[count] = key[1];// ex) 음식종류 -> 음료 일때 str2[count] = {"콜라", "사이다","밀키스","마운틴듀","부산우유"};
                table.addRow(list);//str배열의 텍스트파일의 내용을 메뉴판으로 출력!
                count++;// 행의 길이에따라 count값 증가
            }
            bw2.close();
            br3.close();
            //--
        } catch (Exception e) {
            e.printStackTrace();
        }
        //음식명 콤보박스 초기화
        jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));
    }

    //생성자
    public MenuControl() { // 생성자
        initComponents();
        jButt_Ok.setEnabled(false); //버튼 비활성화
        jLabel_Mod.setVisible(false);//모드라벨 숨기기
        jLabel_Price.setVisible(false);//가격라벨 숨기기
        jLabel_Amount.setVisible(false);//수량라벨 숨기기
        jLabel_FoodN.setVisible(false);//음식명라벨 숨기기
        jCheckBox_Price.setVisible(false);//가격 체크박스 숨기기
        jCheckBox_Amount.setVisible(false);//수량 체크박스 숨기기
        jTextField_Amount.setVisible(false);//수량 텍스트 숨기기
        jTextField_Amount.setEnabled(false);//수량 텍스트 비활성화
        jTextField_Amount.setText("입력불가");
        jTextField_Price.setText("입력불가");
        jTextField_Price.setVisible(false);//가격 텍스트 숨기기
        jTextField_Price.setEnabled(false);//가격 텍스트 비활성화

        jTextField_FoodName.setVisible(false);//음식명 텍스트 숨기기
        jTextField_FoodName.setEnabled(false);//음식명 텍스트 비활성화
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Menu = new javax.swing.JTable();
        jButt_Ok = new javax.swing.JButton();
        jLabel_Amount = new javax.swing.JLabel();
        jLabel_FoodName = new javax.swing.JLabel();
        jLabel_MenuName = new javax.swing.JLabel();
        jTextField_Amount = new javax.swing.JTextField();
        jComboBox_FoodSort = new javax.swing.JComboBox<>();
        jComboBox_FoodName = new javax.swing.JComboBox<>();
        jLabel_FoodSort = new javax.swing.JLabel();
        jLabel_Msg = new javax.swing.JLabel();
        jComboBox_Option = new javax.swing.JComboBox<>();
        jLabel_Option = new javax.swing.JLabel();
        jLabel_Price = new javax.swing.JLabel();
        jTextField_Price = new javax.swing.JTextField();
        jLabel_Mod = new javax.swing.JLabel();
        jCheckBox_Price = new javax.swing.JCheckBox();
        jCheckBox_Amount = new javax.swing.JCheckBox();
        jLabel_Msg2 = new javax.swing.JLabel();
        jLabel_FoodN = new javax.swing.JLabel();
        jTextField_FoodName = new javax.swing.JTextField();
        jLabel_Msg3 = new javax.swing.JLabel();
        jButt_Receipt = new javax.swing.JButton();
        jButt_ReceiptReset = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_Back = new javax.swing.JMenuItem();
        jMenuItem_Exit = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "음식종류", "음식명", "가격", "수량"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Menu.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_Menu);

        jButt_Ok.setText("클릭불가");
        jButt_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_OkActionPerformed(evt);
            }
        });

        jLabel_Amount.setText("수량");

        jLabel_FoodName.setText("음식명");

        jLabel_MenuName.setText("음식종류를 선택해 메뉴판을 불러주세요");

        jTextField_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_AmountActionPerformed(evt);
            }
        });

        jComboBox_FoodSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "선택안함", "음료", "면류", "밥류", "주류", "치킨류" }));
        jComboBox_FoodSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FoodSortActionPerformed(evt);
            }
        });

        jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        jComboBox_FoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FoodNameActionPerformed(evt);
            }
        });

        jLabel_FoodSort.setText("음식 종류");

        jComboBox_Option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "선택", "추가", "수정", "삭제" }));
        jComboBox_Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_OptionActionPerformed(evt);
            }
        });

        jLabel_Option.setText("옵션");

        jLabel_Price.setText("가격");

        jTextField_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_PriceActionPerformed(evt);
            }
        });

        jLabel_Mod.setText("-");

        jCheckBox_Price.setText("가격수정");
        jCheckBox_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_PriceActionPerformed(evt);
            }
        });

        jCheckBox_Amount.setText("수량수정");
        jCheckBox_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_AmountActionPerformed(evt);
            }
        });

        jLabel_FoodN.setText("음식명");

        jTextField_FoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_FoodNameActionPerformed(evt);
            }
        });

        jButt_Receipt.setText("주문내역(영수증)");
        jButt_Receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_ReceiptActionPerformed(evt);
            }
        });

        jButt_ReceiptReset.setText("영수증 초기화");
        jButt_ReceiptReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_ReceiptResetActionPerformed(evt);
            }
        });

        jMenu3.setText("Menu");

        jMenuItem_Back.setText("뒤로가기");
        jMenuItem_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_BackActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_Back);

        jMenuItem_Exit.setText("종료");
        jMenuItem_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ExitActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_Exit);

        jMenuBar2.add(jMenu3);
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_FoodSort)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_FoodSort, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel_Option)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox_Option, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel_Mod, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButt_Receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButt_ReceiptReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButt_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(436, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_FoodN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Msg2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel_Msg3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_Msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(476, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_Option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Option))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_FoodSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_FoodSort))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_FoodName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_Mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_FoodN))
                            .addComponent(jLabel_Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Price)
                            .addComponent(jCheckBox_Price)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel_Msg2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_Amount)
                        .addComponent(jCheckBox_Amount))
                    .addComponent(jLabel_Msg3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButt_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButt_Receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButt_ReceiptReset, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //버튼 이벤트 처리기
    private void jButt_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_OkActionPerformed
        // TODO add your handling code here:
        int num = jComboBox_Option.getSelectedIndex();//음식옵션 인덱스
        int num2 = jComboBox_FoodSort.getSelectedIndex();//음식종류 인덱스

        String FoodName = null; // 음식명

        if (getStr().length > 0) {
            FoodName = jComboBox_FoodName.getSelectedItem().toString();// 음식이름 인덱스
        }
        jLabel_Msg.setForeground(Color.red);// 글자색
        jLabel_Msg.setFont(new Font("Serif", Font.BOLD, 15));// 굵기
        jLabel_Msg2.setForeground(Color.BLUE);// 글자색
        jLabel_Msg2.setFont(new Font("Serif", Font.BOLD, 15));// 굵기
        jLabel_Msg3.setForeground(Color.GREEN);// 글자색
        jLabel_Msg3.setFont(new Font("Serif", Font.BOLD, 15));// 굵기

        String Samount = jTextField_Amount.getText(); // 수량 값
        String Sprice = jTextField_Price.getText(); // 수량 값

        int amount = 0; // 수량값
        int price = 0; // 가격값

        boolean isNumeric = Samount.matches("[+-]?\\d*(\\.\\d+)?");// 숫자만 적어야되요..
        boolean isNumeric2 = Sprice.matches("[+-]?\\d*(\\.\\d+)?");// 숫자만 적어야되요..

        if (num2 == 0) {//선택일때
            jLabel_Msg.setText("음식종류을 선택하세요");
        } else {//추가,수정,삭제 일때
            switch (num) {
                case 1://추가
                    boolean isOk = false;
                    boolean isOk2 = false;
                    jLabel_Msg.setText("");
                    jLabel_Msg2.setText("");
                    jLabel_Msg3.setText("");
                    String str = null;

                    //길이 0보다 크면
                    if (jTextField_FoodName.getText().length() > 0 && jTextField_Price.getText().length() > 0 && jTextField_Amount.getText().length() > 0) {
                        str = jTextField_FoodName.getText().replaceAll("\\s", ""); //공백 없는상태로 음식명 문자열 리턴
                        jLabel_Msg.setText("정상");
                        if (isNumeric) {//숫자라면
                            if (Integer.parseInt(Samount) <= 0) {
                                jLabel_Msg3.setText("올바른 숫자를 적어주세요..");
                                jTextField_Amount.setText("");
                                isOk = false;
                            } else {
                                amount = Integer.parseInt(Samount);
                                jLabel_Msg3.setText("정상");
                                isOk = true; // 정상이면 true 반환
                            }
                        } else {
                            jLabel_Msg3.setText("숫자를 입력해주세요..");
                            jTextField_Amount.setText("");
                            isOk = false;
                        }
                        if (isNumeric2) {
                            if (Integer.parseInt(Sprice) <= 0) {
                                jLabel_Msg2.setText("올바른 숫자를 적어주세요..");
                                jTextField_Price.setText("");
                                isOk2 = false;
                            } else {
                                price = Integer.parseInt(Sprice);
                                jLabel_Msg2.setText("정상");
                                isOk2 = true;// 정상이면 true 반환
                            }
                        } else {
                            jLabel_Msg2.setText("숫자를 입력해주세요..");
                            jTextField_Price.setText("");
                            isOk2 = false;
                        }
                    } else {
                        if (jTextField_FoodName.getText().length() <= 0) {
                            jLabel_Msg.setText("값를 입력해주세요..");
                            jTextField_FoodName.setText("");
                            isOk2 = false;
                        }
                        if (jTextField_Price.getText().length() <= 0) {
                            jLabel_Msg2.setText("값를 입력해주세요..");
                            jTextField_Price.setText("");
                            isOk2 = false;
                        }
                        if (jTextField_Amount.getText().length() <= 0) {
                            jLabel_Msg3.setText("값를 입력해주세요..");
                            jTextField_Amount.setText("");
                            isOk2 = false;
                        }
                    }
                    if (isOk == true && isOk2 == true) { // 정상적으로 입력되면
                        Add(num2, str, price, amount); // 추가 함수 실행
                        jTextField_Amount.setText("");
                        jTextField_Price.setText("");
                        jTextField_FoodName.setText("");
                    }

                    break;

                case 2://수정
                    jLabel_Msg.setText("");
                    jLabel_Msg2.setText("");
                    jLabel_Msg3.setText("");
                    if (getStr().length > 0) { //수정할것이있어야 실행

                        //체크박스둘다 선택안하면..
                        if (!jCheckBox_Amount.isSelected() && !jCheckBox_Price.isSelected()) {
                            jLabel_Msg2.setText("체크박스 선택해주세요");
                            jLabel_Msg3.setText("체크박스 선택해주세요");
                        } else {//그렇지않으면
                            if (jCheckBox_Amount.isSelected()) { // 수량체크박스를 선택할시
                                if (jTextField_Amount.getText().length() > 0) {//길이 0보다 크면
                                    if (isNumeric) {// 숫자라면
                                        if (Integer.parseInt(Samount) <= 0) { // 0이나 음수라면
                                            jLabel_Msg3.setText("올바른 숫자를 적어주세요..");
                                            jTextField_Amount.setText("");
                                        } else { // 정상적으로 입력하면
                                            amount = Integer.parseInt(Samount);
                                            jLabel_Msg3.setText("정상");
                                        }
                                    } else { // 숫자가 아니라면
                                        jLabel_Msg3.setText("숫자를 입력해주세요..");
                                        jTextField_Amount.setText("");
                                    }
                                } else { // 아무것도 안적으면
                                    jLabel_Msg3.setText("값를 입력해주세요..");
                                    jTextField_Amount.setText("");
                                }
                            }
                            if (jCheckBox_Price.isSelected()) { // 가격 체크박스가 선택되면
                                if (jTextField_Price.getText().length() > 0) {//길이 0보다 크면
                                    if (isNumeric2) {// 숫자라면
                                        if (Integer.parseInt(Sprice) <= 0) {// 0이나 음수라면
                                            jLabel_Msg2.setText("올바른 숫자를 적어주세요..");
                                            jTextField_Price.setText("");
                                        } else { // 정상적으로 입력되면
                                            price = Integer.parseInt(Sprice);
                                            jLabel_Msg2.setText("정상");
                                        }
                                    } else { // 숫자가 아니라면
                                        jLabel_Msg2.setText("숫자를 입력해주세요..");
                                        jTextField_Price.setText("");
                                    }
                                } else {// 아무것도 안적으면
                                    jLabel_Msg2.setText("값를 입력해주세요..");
                                    jTextField_Price.setText("");
                                }
                            }
                            Modify(num2, FoodName, amount, price);// 수정함수 실행
                            jTextField_Amount.setText("");
                            jTextField_Price.setText("");
                        }
                    } else { // 수정할것이 없다면
                        jLabel_Msg.setText("수정할 값이 없습니다...");
                    }
                    break;
                case 3://삭제
                    if (getStr().length > 0) { // 삭제할것이 있다면
                        Delete(num2, FoodName);
                    } else { // 없다면
                        jLabel_Msg.setText("삭제할 음식이 없습니다...");
                    }
                    break;
            }
        }
    }//GEN-LAST:event_jButt_OkActionPerformed
// 뒤로가기
    private void jMenuItem_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_BackActionPerformed


    }//GEN-LAST:event_jMenuItem_BackActionPerformed
// 종료하기 이벤트 처리
    private void jMenuItem_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem_ExitActionPerformed
//음식종류 콤보박스 이벤트 처리기
    private void jComboBox_FoodSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FoodSortActionPerformed
        // TODO add your handling code here:
        int index = jComboBox_FoodSort.getSelectedIndex(); //선택된 아이템의 인덱스
        ShowMenu(index);//선택된 음식종류에따라 맞는 메뉴판을 부르는 함수
    }//GEN-LAST:event_jComboBox_FoodSortActionPerformed

    private void jTextField_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_AmountActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField_AmountActionPerformed

//음식명 콤보박스 이벤트 처리기
    private void jComboBox_FoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FoodNameActionPerformed
        // TODO add your handling code here:
        int num = jComboBox_FoodSort.getSelectedIndex();//음식종류 콤보박스 번호
        if (num == 0) {//선택안함 선택시 택스트필드에 출력
            jTextField_Amount.setText("입력불가");
            jTextField_Amount.setEnabled(false); // 수량 비활성화
            jTextField_Price.setText("입력불가");
            jTextField_Price.setEnabled(false); // 가격 비활성화
            jTextField_FoodName.setText("입력불가");
            jTextField_FoodName.setEnabled(false); // 음식명 비활성화
        } else {//선택안함이외 선택시
            jTextField_Amount.setText(""); // 공백 출력
            jTextField_Price.setText("");// 공백 출력
            jTextField_FoodName.setText("");// 공백 출력
        }
    }//GEN-LAST:event_jComboBox_FoodNameActionPerformed
//옵션 콤보박스
    private void jComboBox_OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_OptionActionPerformed
        // TODO add your handling code here:
        int num = jComboBox_Option.getSelectedIndex();//음식옵션 인덱스

        switch (num) {
            case 0://선택일때
                jButt_Ok.setText("클릭불가");
                jButt_Ok.setEnabled(false);// 버튼 비활성화

                jLabel_Mod.setVisible(false);// 모드 라벨 숨기기
                jLabel_Price.setVisible(false);// 가격 라벨 숨기기
                jLabel_Amount.setVisible(false);// 수량 라벨 숨기기
                jCheckBox_Price.setVisible(false);// 가격 체크박스 숨기기
                jCheckBox_Amount.setVisible(false);// 수량 체크박스 숨기기
                jTextField_Amount.setVisible(false);// 수량 텍스트 숨기기
                jTextField_Price.setVisible(false);// 가격 텍스트 숨기기
                jLabel_Msg.setText("");//공백 초기화
                jLabel_Msg2.setText("");//공백 초기화
                jLabel_Msg3.setText("");//공백 초기화

                jLabel_Mod.setText("");//공백 초기화
                jLabel_FoodN.setVisible(false); // 음식 라벨 숨기기
                jTextField_FoodName.setVisible(false); //음식명 텍스트 숨기기

                jLabel_FoodName.setVisible(true);// 상단 음식 라벨 보이기
                jComboBox_FoodName.setVisible(true);// 음식 콤보박스 보이기
                break;
            case 1://추가일때
                jButt_Ok.setText("추가하기");
                jButt_Ok.setEnabled(true);//버튼 활성화

                jLabel_Mod.setVisible(true);//모드라벨 보이기
                jLabel_Price.setVisible(true);//가격 라벨 보이기
                jLabel_Amount.setVisible(true);// 수량 라벨 보이기
                jCheckBox_Price.setVisible(false);// 가격 체크박스 숨기기
                jCheckBox_Amount.setVisible(false);// 수량 체크박스 숨기기
                jTextField_Amount.setVisible(true);// 수량 텍스트 보이기
                jTextField_Price.setVisible(true);//가격 텍스트 보이기

                jLabel_Mod.setText("추가할 값을 적으세요");
                jLabel_FoodN.setVisible(true);// 하단 음식명 라벨 보이기
                jTextField_FoodName.setVisible(true);// 음식명 텍스트 보이기
                jTextField_Amount.setEnabled(true);// 수량 텍스트 활성화
                jTextField_Price.setEnabled(true);// 가격 텍스트 활성화
                jTextField_FoodName.setEnabled(true);// 음식명 텍스트 활성화
                jTextField_Amount.setText("");
                jTextField_Price.setText("");
                jTextField_FoodName.setText("");
                jLabel_FoodName.setVisible(false);//상단 음식명 라벨 숨기기
                jComboBox_FoodName.setVisible(false);//음식명 콤보박스 숨기기
                jLabel_Msg.setText("");
                jLabel_Msg2.setText("");
                jLabel_Msg3.setText("");
                break;
            case 2:
                jButt_Ok.setText("수정하기");
                jButt_Ok.setEnabled(true);// 버튼활성화

                jLabel_Mod.setVisible(true); // 모드 라벨 보이기
                jLabel_Price.setVisible(true);// 가격 라벨 보이기
                jLabel_Amount.setVisible(true);// 수량 라벨 보이기
                jCheckBox_Price.setVisible(true);// 가격 체크박스 보이기
                jCheckBox_Amount.setVisible(true);// 수량 체크박스 보이기
                jTextField_Price.setEnabled(false);//가격 텍스트 비활성화
                jTextField_Amount.setEnabled(false);//수량 텍스트 비활성화
                jTextField_Amount.setVisible(true);//수량 텍스트 보이기
                jTextField_Price.setVisible(true);//가격 텍스트 보이기
                jCheckBox_Amount.setSelected(false);// 수량체크박스 체크해제
                jCheckBox_Price.setSelected(false);// 가격체크박스 체크해제
                jTextField_Amount.setText("입력불가");
                jTextField_Price.setText("입력불가");

                jLabel_Mod.setText("수정할 값을 적으세요");
                jLabel_FoodN.setVisible(false); //하단 음식명 라벨 숨기기
                jTextField_FoodName.setVisible(false);//음식명 텍스트 숨기기
                jTextField_FoodName.setEnabled(false);// 음식명 텍스트 비활성화

                jLabel_FoodName.setVisible(true);//상단 음식명 라벨 보이기
                jComboBox_FoodName.setVisible(true);//음식명 콤보박스 보이기
                jLabel_Msg.setText("");
                jLabel_Msg2.setText("");
                jLabel_Msg3.setText("");
                break;
            case 3:
                jButt_Ok.setText("삭제하기");
                jButt_Ok.setEnabled(true);//버튼 활성화

                jLabel_Mod.setVisible(true);//모드 라벨 보이기
                jLabel_Price.setVisible(false);//가격 라벨 숨기기
                jLabel_Amount.setVisible(false);//수량 라벨 숨기기
                jCheckBox_Price.setVisible(false);//가격 체크박스 숨기기
                jCheckBox_Amount.setVisible(false);//수량 체크박스 숨기기
                jTextField_Amount.setVisible(false);//수량 텍스트 숨기기
                jTextField_Price.setVisible(false);//가격 텍스트 숨기기

                jLabel_Mod.setText("삭제할 음식을 선택하세요");
                jLabel_FoodN.setVisible(false);// 하단 음식명 라벨 숨기기
                jTextField_FoodName.setVisible(false);// 음식명 텍스트 숨기기

                jLabel_FoodName.setVisible(true);// 상단 음식명 라벨 보이기
                jComboBox_FoodName.setVisible(true);// 음식명 콤보박스 보이기
                jLabel_Msg.setText("");
                jLabel_Msg2.setText("");
                jLabel_Msg3.setText("");
                break;
        }
    }//GEN-LAST:event_jComboBox_OptionActionPerformed

    private void jTextField_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_PriceActionPerformed
    //가격 체크박스
    private void jCheckBox_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_PriceActionPerformed
        // TODO add your handling code here:
        if (jCheckBox_Price.isSelected()) {// 가격 체크박스가 선택되면
            jTextField_Price.setEnabled(true);// 가격 텍스트 활성화
            jTextField_Price.setText("");// 공백 초기화
        } else if (!jCheckBox_Price.isSelected()) {//해제되면
            jTextField_Price.setEnabled(false);// 가격 텍스트 비활성화
            jTextField_Price.setText("입력불가");
        }
    }//GEN-LAST:event_jCheckBox_PriceActionPerformed
    //수량 체크박스
    private void jCheckBox_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_AmountActionPerformed
        // TODO add your handling code here:
        if (jCheckBox_Amount.isSelected()) {//수량 체크박스가 선택되면
            jTextField_Amount.setEnabled(true);//수량 체크박스가 활성화
            jTextField_Amount.setText("");//공백 초기화
        } else if (!jCheckBox_Amount.isSelected()) {//해제되면
            jTextField_Amount.setEnabled(false);//수량 체크박스가 비활성화
            jTextField_Amount.setText("입력불가");
        }
    }//GEN-LAST:event_jCheckBox_AmountActionPerformed

    private void jTextField_FoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_FoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_FoodNameActionPerformed
    //영수증 버튼
    private void jButt_ReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_ReceiptActionPerformed
        // TODO add your handling code here:
        Receipt receipt = new Receipt();
        receipt.setOption(1); // 1은 매니져
        receipt.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButt_ReceiptActionPerformed
    //영수증 초기화
    private void jButt_ReceiptResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_ReceiptResetActionPerformed
        // TODO add your handling code here:
        try {//처음에 Bill.txt파일 내용 삭제
            FileOutputStream fileout = new FileOutputStream("Bill.txt");
            String text = "";
            fileout.write(text.getBytes());
            fileout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(null, "초기화 완료!");//메세지 창 출력
    }//GEN-LAST:event_jButt_ReceiptResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test1.MenuControl.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test1.MenuControl.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test1.MenuControl.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test1.MenuControl.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test1.MenuControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButt_Ok;
    private javax.swing.JButton jButt_Receipt;
    private javax.swing.JButton jButt_ReceiptReset;
    private javax.swing.JCheckBox jCheckBox_Amount;
    private javax.swing.JCheckBox jCheckBox_Price;
    private javax.swing.JComboBox<String> jComboBox_FoodName;
    private javax.swing.JComboBox<String> jComboBox_FoodSort;
    private javax.swing.JComboBox<String> jComboBox_Option;
    private javax.swing.JLabel jLabel_Amount;
    private javax.swing.JLabel jLabel_FoodN;
    private javax.swing.JLabel jLabel_FoodName;
    private javax.swing.JLabel jLabel_FoodSort;
    private javax.swing.JLabel jLabel_MenuName;
    private javax.swing.JLabel jLabel_Mod;
    private javax.swing.JLabel jLabel_Msg;
    private javax.swing.JLabel jLabel_Msg2;
    private javax.swing.JLabel jLabel_Msg3;
    private javax.swing.JLabel jLabel_Option;
    private javax.swing.JLabel jLabel_Price;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem_Back;
    private javax.swing.JMenuItem jMenuItem_Exit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Menu;
    private javax.swing.JTextField jTextField_Amount;
    private javax.swing.JTextField jTextField_FoodName;
    private javax.swing.JTextField jTextField_Price;
    // End of variables declaration//GEN-END:variables
}
