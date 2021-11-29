/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author me
 */
public class OrderMenu2 extends javax.swing.JFrame {

    String line2 = "";//영수증을 출력을 위한 변수

    String[] key = null; //getFoodNameList()에서 해당음식명의 한행을 담는배열 //ex)[음료, 콜라, 1000, 15]
    String[] str2 = new String[100];// 음식명 담는 배열  최대100개 //ex)[콜라, 사이다,밀키스,마운틴듀,부산우유]
    int count = 1;// 행의 길이에따라 jComboBox_FoodName 길이를 증가시키기위해서 
    int Allprice = 0; // 누적비용
    int priceCount; // 수량값.

    /**
     * Creates new form OrderMenu2
     */
    // ShowMenu(int index)에서 index가 0일때 메뉴판을 초기화시킴
    public void Order() {
        DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
        table.setNumRows(0);// 테이블 초기화
    }

    //ShowMenu(int index)에서 index(1~5)에따라 해당 메뉴판을 jTable에 출력함
    public void Order(String str) {

        jTextField_Amount.setText("");// 텍스트필드 공백으로 초기화

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

    //음식 주문하기 버튼을 클릭하면 해당음식종류의 텍스트파일2가 생기고 그것을 바탕으로 다시 원본에 넣어서 메뉴판을 출력함
    public void Order(int num, String FoodName) {
        String[] str = {"", "drinkMenu.txt", "noodleMenu.txt", "riceMenu.txt", "alcolMenu.txt", "chickenMenu.txt"};
        String[] str2 = {"", "drinkMenu2.txt", "noodleMenu2.txt", "riceMenu2.txt", "alcolMenu2.txt", "chickenMenu2.txt"};
        jTextField_Amount.setText("");
        File menu_file = new File(str[num]);//num에따른 텍스트배열을 불러서 생성

        try {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(menu_file), "UTF8"));//1파일읽기        
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str2[num]), "UTF8"));//2파일 쓰기

            DefaultTableModel table = (DefaultTableModel) jTable_Menu.getModel();
            table.setNumRows(0);// 테이블 초기화

            String line;
            String[] key;
            count = 0;// 행 길이

            // 한 행씩 읽어서 한 행씩 테이블에 저장
            while ((line = bufReader.readLine()) != null) {//2파일에 기록하기
                key = line.split("/");
                if (key[1].equals(FoodName)) {
                    key = line.split("/");//문자열을 자르고 배열로 리턴
                    key[3] = String.valueOf(Integer.parseInt(key[3]) - priceCount);//입력받은 수량값을 빼기
                    line = String.format("%s/%s/%s/%s", key[0], key[1], key[2], key[3]);//문자열을 쓰기
                }
                bw.write(line + "\r\n");//텍스트파일에 line의 값을 쓴다.
                bw.flush();
            }
            bw.close();
            bufReader.close();
            //----
            BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(str2[num]), "UTF8"));//2파일읽기        
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str[num]), "UTF8"));//1파일 쓰기

            while ((line = br2.readLine()) != null) {
                bw2.write(line + "\r\n");//str2의 배열의 텍스트파일 내용을 str배열의 텍스트파일에 쓰기
                bw2.flush();
            }
            bw2.close();
            br2.close();
            //--
            BufferedReader br3 = new BufferedReader(new InputStreamReader(new FileInputStream(str[num]), "UTF8"));//1파일읽기

            while ((line = br3.readLine()) != null) {
                key = line.split("/");
                Object[] list = {key[0], key[1], key[2], key[3]};
                table.addRow(list);//str배열의 텍스트파일의 내용을 메뉴판으로 출력!
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

    //한 행을 읽어서 해당 음식명의 행을 배열로 리턴
    public String[] getFoodNameList(int num, String FoodName) {
        String[] str = {"", "drinkMenu.txt", "noodleMenu.txt", "riceMenu.txt", "alcolMenu.txt", "chickenMenu.txt"};
        File bill_file = new File(str[num]);//num에따른 배열의 값의 텍스트파일을 생성

        try {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(bill_file), "UTF8"));//파일읽기     

            String line;
            // 한 행씩 읽어서 한 행씩 테이블에 저장
            while ((line = bufReader.readLine()) != null) {
                key = line.split("/");
                if (key[1].equals(FoodName)) {
                    key = line.split("/");//ex)[음료, 콜라, 1000, 15]
                    break;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return key;// 리턴!
    }

    //음식종류 콤보박스에 따라 호출되는 함수!
    public void ShowMenu(int index) {
        switch (index) {
            case 0://선택안함
                jLabel_Msg.setText("");//공백으로 초기화
                jTextField_Amount.setText(" 입력불가 "); //수량적는칸에 표시
                jTextField_Amount.setEnabled(false);// 선택안할시 만질수없게 함
                jLabel_MenuName.setText("음식종류를 선택해 메뉴판을 불러주세요");
                Order();// 일반함수 실행
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"---"}));
                break;
            case 1:// 음료
                jLabel_Msg.setText("");//공백으로 초기화
                jTextField_Amount.setEnabled(true);// 값을 입력할수 있게함
                jLabel_MenuName.setText("음료 메뉴판!");
                Order("drinkMenu.txt");//메뉴판을 부르기위해
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));// 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                break;
            case 2:// 면류
                jLabel_Msg.setText("");//공백으로 초기화
                jTextField_Amount.setEnabled(true);// 값을 입력할수 있게함
                jLabel_MenuName.setText("면류 메뉴판!");
                Order("noodleMenu.txt");//메뉴판을 부르기위해
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));// 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                break;
            case 3:// 밥류
                jLabel_Msg.setText("");//공백으로 초기화
                jTextField_Amount.setEnabled(true);// 값을 입력할수 있게함
                jLabel_MenuName.setText("밥류 메뉴판!");
                Order("riceMenu.txt");//메뉴판을 부르기위해
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));// 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                break;
            case 4:// 주류
                jLabel_Msg.setText("");//공백으로 초기화
                jTextField_Amount.setEnabled(true);// 값을 입력할수 있게함
                jLabel_MenuName.setText("주류 메뉴판!");
                Order("alcolMenu.txt");//메뉴판을 부르기위해
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));// 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                break;
            case 5:// 치킨류
                jLabel_Msg.setText("");//공백으로 초기화
                jTextField_Amount.setEnabled(true);// 값을 입력할수 있게함
                jLabel_MenuName.setText("치킨류 메뉴판!");
                Order("chickenMenu.txt");//메뉴판을 부르기위해
                jComboBox_FoodName.setModel(new javax.swing.DefaultComboBoxModel<>(getStr()));// 해당음식종류에 맞는 음식명을 jComboBox_FoodName에 표시
                break;
        }
    }

    //생성자
    public OrderMenu2() { // 생성자
        initComponents();
        jTextField_Amount.setEnabled(false);//실행시 만질수 없게함
        jTextField_Amount.setText(" 입력불가 ");//실행시 텍스트필드에 표시
        try {//처음에 Bill.txt파일 내용 삭제
            FileOutputStream fileout = new FileOutputStream("Bill.txt");
            String text = "";
            fileout.write(text.getBytes());
            fileout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Menu = new javax.swing.JTable();
        jButt_Order = new javax.swing.JButton();
        jLabel_Amount = new javax.swing.JLabel();
        jLabel_FoodName = new javax.swing.JLabel();
        jLabel_MenuName = new javax.swing.JLabel();
        jTextField_Amount = new javax.swing.JTextField();
        jComboBox_FoodSort = new javax.swing.JComboBox<>();
        jComboBox_FoodName = new javax.swing.JComboBox<>();
        jLabel_FoodSort = new javax.swing.JLabel();
        jLabel_Msg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_Back = new javax.swing.JMenuItem();
        jMenuItem_Exit = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jScrollPane2.setViewportView(jTree1);

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

        jButt_Order.setText("주문하기!");
        jButt_Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_OrderActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("휴먼옛체", 0, 28)); // NOI18N
        jLabel1.setText("< Food Order >");

        jLabel2.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        jLabel2.setText("( 음식 주문 )");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButt_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_FoodSort, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel_FoodName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_FoodSort, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel_MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel_Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox_FoodSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_FoodSort))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox_FoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_FoodName))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Amount))
                                .addGap(42, 42, 42)))
                        .addComponent(jButt_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //버튼 이벤트 처리기
    private void jButt_OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_OrderActionPerformed
        // TODO add your handling code here:
        String line = null;
        int sum = 0;
        count = 0;
        int num = jComboBox_FoodSort.getSelectedIndex(); //음식종류 콤보박스 번호
        String str = jTextField_Amount.getText(); // 수량 값

        jLabel_Msg.setForeground(Color.red);// 글자색
        jLabel_Msg.setFont(new Font("Serif", Font.BOLD, 15));// 굵기

        boolean isNumeric = str.matches("[+-]?\\d*(\\.\\d+)?");// 숫자만 적어야되요..

        if (num != 0) {//선택안함을 선택할시 수행
            if (jTextField_Amount.getText().length() > 0) {
                if (!isNumeric) {//숫자가 아니라면
                    jLabel_Msg.setText("숫자를 입력하세요..");
                    jTextField_Amount.setText("");
                } else {//숫자면
                    priceCount = Integer.parseInt(jTextField_Amount.getText()); // 수량 값
                    jLabel_Msg.setText("정상적으로 입력하셨습니다!");
                    String FoodName = jComboBox_FoodName.getSelectedItem().toString();
                    String[] FoodNameList = getFoodNameList(num, FoodName);//[음료, 콜라, 1000, 1] 등등 리턴!
                    if (Integer.parseInt(FoodNameList[3]) < priceCount) {//입력받은값이 현재수량보다 많다면
                        jLabel_Msg.setText("수량이 부족합니다..");
                    } else if (Integer.parseInt(str) <= 0) {//텍스트 필드에 음수와 0을 입력시 
                        jLabel_Msg.setText("올바른 값을 입력해주세요..");
                    } else {// 올바르게 입력시
                        sum = Integer.parseInt(FoodNameList[2]) * priceCount; //해당음식 총가격
                        Allprice += Integer.parseInt(FoodNameList[2]) * priceCount;// 누적가격
                        File Bill_List = new File("Bill.txt");
                        try {
                            BufferedWriter filewriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Bill_List, true), "UTF8"));//2파일 쓰기
                            //FileWriter filewriter = new FileWriter(Bill_List, true);

                            // 파일에 저장(음식종류/음식명/ 가격/주문한 수량/총가격/ 누적비용)
                            line = String.format("%s/%s/%d/%d/%d/%d%n", FoodNameList[0], FoodNameList[1], Integer.parseInt(FoodNameList[2]), priceCount, sum, Allprice);
                            filewriter.write(line);
                            filewriter.flush();
                            filewriter.close();

                            Order(num, FoodName); // 실행
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        line2 += "------영수증-------\n";
                        line2 += String.format("음식종류=>%s%n"
                                + "음식명=>%s%n"
                                + "음식가격=>%d%n"
                                + "주문한 수량=>%d%n"
                                + "해당음식 총가격=>%d%n"
                                + "누적 가격=>%d%n", FoodNameList[0], FoodNameList[1], Integer.parseInt(FoodNameList[2]), priceCount, sum, Allprice);
                        line2 += "------------------\n\n";
                        JOptionPane.showMessageDialog(null, line2);//메세지 창 출력
                    }
                }
            } else {//음식종류를 선택하고 입력값을 안적을시
                jLabel_Msg.setText("수량을 입력하세요..");
            }
        } else {//음식종류를 선택안하고 버튼누를시
            jLabel_Msg.setText("음식종류를 선택하세요..");
        }

    }//GEN-LAST:event_jButt_OrderActionPerformed

// 뒤로가기
    private void jMenuItem_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_BackActionPerformed

        staff_List lis = new staff_List();
        lis.setVisible(true);
        setVisible(false);

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
            jTextField_Amount.setText(" 입력불가");
        } else {//선택안함이외 선택시
            jTextField_Amount.setText(""); // 공백 출력
        }
    }//GEN-LAST:event_jComboBox_FoodNameActionPerformed

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
            java.util.logging.Logger.getLogger(OrderMenu2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderMenu2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderMenu2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderMenu2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderMenu2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButt_Order;
    private javax.swing.JComboBox<String> jComboBox_FoodName;
    private javax.swing.JComboBox<String> jComboBox_FoodSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Amount;
    private javax.swing.JLabel jLabel_FoodName;
    private javax.swing.JLabel jLabel_FoodSort;
    private javax.swing.JLabel jLabel_MenuName;
    private javax.swing.JLabel jLabel_Msg;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem_Back;
    private javax.swing.JMenuItem jMenuItem_Exit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Menu;
    private javax.swing.JTextField jTextField_Amount;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
