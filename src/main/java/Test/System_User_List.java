/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author 916
 */
public class System_User_List extends javax.swing.JFrame {
    
    int count = 0;
    
    // 직원 정보 ArrayList 생성
    ArrayList<staff> st_list = new ArrayList<staff>(); 
    
    // 메니저 정보 ArrayList 생성
    ArrayList<manager> mg_list = new ArrayList<manager>(); 
    
    
    // 직원 정보 마우스로 누른 키값 전달
    public String getKey(JTable jTable1){
        
        String key = null;
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int row = jTable1.getSelectedRow();
        key = (String) model.getValueAt(row, 0);
        
        return key;
    }
    
    
    // 직원 정보 txt파일을 ArrayList에 저장
    public void getst_list( ArrayList<staff> st_list) throws FileNotFoundException, IOException{
    
        String str;
        String[] key;
        
        st_list.clear();
        
        // 텍스트파일 생성
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("s_login_info.txt")));
        
        // txt 파일 한 행씩 읽어서 ArrayList에 저장
        while((str = read.readLine()) != null){
            key = str.split("/");
            st_list.add(new staff(key[0], key[1]));
        }
        read.close();
    }
    
    
    // 메니저 정보 마우스로 누른 키값 전달
    public String getKey1(JTable jTable2){
        
        String key = null;
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int row = jTable2.getSelectedRow();
        key = (String) model.getValueAt(row, 0);
        
        return key;
    }
    
    
    // 메니저 정보 txt파일을 ArrayList에 저장
    public void getmg_list( ArrayList<manager> mg_list) throws FileNotFoundException, IOException{
    
        String str;
        String[] key;
        
        mg_list.clear();
        
        // 텍스트파일 생성
        BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream("m_login_info.txt")));
        
        // txt 파일 한 행씩 읽어서 ArrayList에 저장
        while((str = read.readLine()) != null){
            key = str.split("/");
            mg_list.add(new manager(key[0], key[1]));
        }
    }
    
    
    staff pp = new staff();
    manager p2 = new manager();

    // 스테프 테이블 출력
    public void staff() {
        
    // 스테프 목록 텍스트 파일 생성
    File staff_list = new File("s_login_info.txt");
    
     try {
        FileReader filereader = null;
        filereader = new FileReader(staff_list);
        
        BufferedReader bufReader = new BufferedReader(filereader);
        DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
        
        String line;
        String[] key;
        
      
        // 한 행씩 읽어서 한 행씩 테이블에 저장
        while((line = bufReader.readLine()) != null){
            key = line.split("/");
            Object[] list = {key[0],key[1]};
            table.addRow(list);
                
        }

    }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
            e.getStackTrace();
        }
}
    
    
    // 메니저 테이블 출력
    public void manager() {
        
    // 메니저 목록 텍스트 파일 생성
    File staff_list = new File("m_login_info.txt");
    
     try {
        FileReader filereader = null;
        filereader = new FileReader(staff_list);
        
        BufferedReader bufReader = new BufferedReader(filereader);
        DefaultTableModel table = (DefaultTableModel)jTable2.getModel();
        
        String line;
        String[] key;
        
      
        // 한 행씩 읽어서 한 행씩 테이블에 저장
        while((line = bufReader.readLine()) != null){
            key = line.split("/");
            Object[] list = {key[0],key[1]};
            table.addRow(list);
                
        }

    }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
            e.getStackTrace();
        }
}

    

    /**
     * Creates new form staff_manager_List
     */
    public System_User_List() {
        initComponents();
        staff();
        manager();
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PW"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("휴먼옛체", 0, 14)); // NOI18N
        jLabel1.setText(" Staff Info");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PW"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("휴먼옛체", 0, 14)); // NOI18N
        jLabel2.setText(" Manager Info");

        jLabel3.setFont(new java.awt.Font("휴먼옛체", 0, 18)); // NOI18N
        jLabel3.setText("System User List");

        jLabel4.setText("( 직원/매니저 리스트 )");

        jButton2.setText("추가");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("수정");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("삭제");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("추가");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("수정");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("삭제");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("휴먼옛체", 0, 18)); // NOI18N
        jLabel5.setText("Modify_Columns");

        jLabel6.setText(" ( 직원/매니저 리스트 )");

        jLabel7.setFont(new java.awt.Font("휴먼옛체", 0, 14)); // NOI18N
        jLabel7.setText("ID : ");

        jLabel8.setFont(new java.awt.Font("휴먼옛체", 0, 14)); // NOI18N
        jLabel8.setText("PW : ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton7.setText("Modify");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        jMenuItem1.setText("뒤로가기");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("종료");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 102, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField1)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addComponent(jButton7)))
                                .addContainerGap(62, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(jButton7)
                                        .addGap(7, 7, 7)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // 메뉴 -> 뒤로가기
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        manager_List p = new manager_List();
        p.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    // 메뉴 -> 종료
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    // 직원 추가
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        staff_Info_add ad = new staff_Info_add();
        ad.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    // 직원 수정
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
        String str;
        String key = getKey(jTable1);
        FileOutputStream file;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try{
            getst_list(st_list);
            for(int i = 0; i<st_list.size(); i++){
                if(key.equals(st_list.get(i).getID())){
                    jTextField1.setText(st_list.get(i).getID());
                    jTextField2.setText(st_list.get(i).getPW());
                    count = 1;
                }
            }
  
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    // 직원 삭제
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String str;
        String key = getKey1(jTable1);
        FileOutputStream file;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try{
            getst_list(st_list);
            
            for(int i = 0; i<st_list.size(); i++){
                if(key.equals(st_list.get(i).getID()))
                    st_list.remove(i);
            }
            
            file = new FileOutputStream("s_login_info.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file));
            
            for(int i = 0; i < st_list.size(); i++){
                str = String.format("%s/%s%n", st_list.get(i).getID(),st_list.get(i).getPW());
                writer.write(str);
            }
            writer.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    
    // 메니저 추가
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Manager_Info_add md = new Manager_Info_add();
        md.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // 메니저 수정
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        String str;
        String key = getKey1(jTable2);
        FileOutputStream file;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        try{
            getmg_list(mg_list);
            for(int i = 0; i<mg_list.size(); i++){
                if(key.equals(mg_list.get(i).getID())){
                    jTextField1.setText(mg_list.get(i).getID());
                    jTextField2.setText(mg_list.get(i).getPW());
                    count = 2;
                }
            }
  
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    
    // 메니저 삭제
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        String str;
        String key = getKey(jTable2);
        FileOutputStream file;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        try{
            getmg_list(mg_list);
            
            for(int i = 0; i<mg_list.size(); i++){
                if(key.equals(mg_list.get(i).getID()))
                    mg_list.remove(i);
            }
            
            file = new FileOutputStream("m_login_info.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file));
            
            for(int i = 0; i < mg_list.size(); i++){
                str = String.format("%s/%s%n", mg_list.get(i).getID(),mg_list.get(i).getPW());
                writer.write(str);
            }
            writer.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    
    // 수정란 ID Field
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    
    // 수정란 수정 버튼
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    String id = jTextField1.getText();
    String pw = jTextField2.getText();
    
    // 직원 수정 버튼 클릭시
    if(count == 1){
        
        String str;
        String key = getKey1(jTable1);
        FileOutputStream file;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try{
            getst_list(st_list);
            
            file = new FileOutputStream("s_login_info.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file));
            
            for(int i = 0; i<st_list.size(); i++){
                if(key.equals(st_list.get(i).getID())){
                    st_list.get(i).setId(id);
                    st_list.get(i).setPw(pw);
                }
                str = String.format("%s/%s%n", st_list.get(i).getID(),st_list.get(i).getPW());
                writer.write(str);
            }
            writer.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        jTextField1.setText("");
        jTextField2.setText("");
        
        JOptionPane.showMessageDialog(null, "수정 완료", "Result", JOptionPane.WARNING_MESSAGE);
        
        // 새로고침
        System_User_List open = new System_User_List();
        open.setVisible(true);
        setVisible(false);
        
    }
    
    // 매니저 수정 버튼 클릭시
    if(count == 2){
                
        String str;
        String key = getKey1(jTable2);
        FileOutputStream file;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        try{
            getmg_list(mg_list);
            
            file = new FileOutputStream("m_login_info.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(file));
            
            for(int i = 0; i<mg_list.size(); i++){
                if(key.equals(mg_list.get(i).getID())){
                    mg_list.get(i).setId(id);
                    mg_list.get(i).setPw(pw);
                }
                str = String.format("%s/%s%n", mg_list.get(i).getID(),mg_list.get(i).getPW());
                writer.write(str);
            }
            writer.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Reservation_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        jTextField1.setText("");
        jTextField2.setText("");
        
        JOptionPane.showMessageDialog(null, "수정 완료", "Result", JOptionPane.WARNING_MESSAGE);
        
        // 새로고침
        System_User_List open = new System_User_List();
        open.setVisible(true);
        setVisible(false);
        
    }
    
    }//GEN-LAST:event_jButton7ActionPerformed


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
            java.util.logging.Logger.getLogger(System_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(System_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(System_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(System_User_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new System_User_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}