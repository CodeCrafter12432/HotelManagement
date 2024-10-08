
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Satham.Lahari
 */
public class staffdetails extends javax.swing.JFrame {
    Connection conn=null;
    Statement st=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    /**
     * Creates new form staffdetails
     */
    public staffdetails() {
        initComponents();
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://localhost:3306/login?zeroDateTimeBehavior=CONVERT_TO_NULL";
             //"jdbc:MySQL://localhost:3306/dbms_project";//?useSSL=false
             String mysql_user="root";
             String mysqlpswrd="Lahari@123";
             conn = DriverManager.getConnection(url,mysql_user,mysqlpswrd);
            Statement stm =(Statement) conn.createStatement();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(manageroom.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(manageroom.class.getName()).log(Level.SEVERE, null, ex);
         }
        checkin();
        showrecordtable();
    }

 public void checkin() {
    try {
        // Select roomnumber based on bed, roomtype, and status
       pst = conn.prepareStatement("select name from hotelstaff where status=?");
       pst.setString(1, "readtowork");
        rs = pst.executeQuery();

        // Populate comboroomnumber with available room numbers
        comsn.removeAllItems();
        while (rs.next()) {
            comsn.addItem(rs.getString("name"));
        }
        
       
        pst = conn.prepareStatement("select roomno from hotelrooms where status=?");
        pst.setString(1, "not-booked");
        rs = pst.executeQuery();

        // Populate comboroomnumber with available room numbers
        comboroomnumber.removeAllItems();
        while (rs.next()) {
            comboroomnumber.addItem(rs.getString("roomno"));
        }

        // Select price based on selected roomtype and bedtype
       
    } catch (SQLException ex) {
        Logger.getLogger(customercheckin.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  public void showrecordtable(){
         int c=0;
         try {
             pst=conn.prepareStatement("select * from hotelstaff");
             rs=pst.executeQuery();
             ResultSetMetaData rsmd=rs.getMetaData();
             c=rsmd.getColumnCount();
             DefaultTableModel Dmodel=(DefaultTableModel) jTable1.getModel();
             Dmodel.setRowCount(0);
             while(rs.next()){
                 Vector column=new Vector();
                 for(int i=1;i<=c;i++)
                 {
                     column.add(rs.getString("staffno"));
                     column.add(rs.getString("name"));
                     column.add(rs.getString("mobile"));
                     column.add(rs.getString("status"));
                     column.add(rs.getString("roomno"));
                 }
                 Dmodel.addRow(column);
             }
         } catch (SQLException ex) {
             Logger.getLogger(manageroom.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textmobilenumber = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        comsn = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        textan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboroomnumber = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("             staff details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 11, 425, 56));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "staffname", "name", "mobile", "status", "roomnumber"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 930, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Satham.Lahari\\Downloads\\dbmspro\\cancel (1).png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 0, 40, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("staffno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));
        getContentPane().add(textmobilenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 140, 30));

        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setText("enterdetails");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 200, -1, -1));

        getContentPane().add(comsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 120, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("mobile");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, -1, -1));
        getContentPane().add(textan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 150, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("roomnumber");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        comboroomnumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(comboroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 120, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Satham.Lahari\\Downloads\\dbmspro\\backk (1).jpg")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
      if(textmobilenumber.getText().equals("")){
            textmobilenumber.requestFocus();
            JOptionPane.showMessageDialog(this,"all details to be filled");
        }
     
        else{
            try {
                pst=conn.prepareStatement("insert into hotelstaff(staffno,name,mobile,status,roomno)values(?,?,?,?,?)");
                pst.setString(1,textmobilenumber.getText());
                pst.setString(2,comsn.getItemAt(comsn.getSelectedIndex()));
                pst.setString(3,textan.getText());
                pst.setString(4,"readtowork");
                pst.setString(5,comboroomnumber.getItemAt(comboroomnumber.getSelectedIndex()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"staffdetails entered successfull");
                textan.setText("");
                textmobilenumber.setText("");
                pst=conn.prepareStatement("update staffdetails set status=? where staffname=?");
                pst.setString(1,"engagedinwork");
                pst.setString(2,comsn.getItemAt(comsn.getSelectedIndex()));
                pst.executeUpdate();
                checkin();
                showrecordtable();
            } catch (SQLException ex) {
                Logger.getLogger(customercheckin.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }//GEN-LAST:event_jButton4ActionPerformed
    }
    
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
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffdetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new staffdetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboroomnumber;
    private javax.swing.JComboBox<String> comsn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textan;
    private javax.swing.JTextField textmobilenumber;
    // End of variables declaration//GEN-END:variables
}
