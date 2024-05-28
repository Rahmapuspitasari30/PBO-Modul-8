/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplication;

/**
 *
 * @author Lenovo
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class apk extends javax.swing.JFrame {

    /**
     * Creates new form apk
     */
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.koneksiDatabase.BukaKoneksi();
    public apk() {
        initComponents();
        tampilData();
    }
    
    private void Bersih(){
        taskName.setText(" ");
        due_date.setText(" ");
        due_time.setText(" ");
        
        btnSimpan.setText("Simpan");
    }
    
    private void tampilData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM biodata");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("taskName");
            model.addColumn("due_date");
            model.addColumn("due_time");
            
            model.getDataVector() .removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            int no = 1;
            
            while (rs.next()) {
                Object[] data = {
                    no ++,
                    rs.getString("taskName"),
                    rs.getString("due_date"),
                    rs.getString("due_time")
                }; 
                model.addRow (data);
                tblData.setModel (model);
            }
        } catch (Exception e) {
            
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
        jLabel2 = new javax.swing.JLabel();
        taskName = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        due_date = new javax.swing.JFormattedTextField();
        due_time = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setText("Nama Tugas");

        jLabel2.setText("Tanggal Deadline");

        taskName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskNameActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel3.setText("jam Deadline");

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        due_date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        due_date.setText("yyyy-mm-dd");

        due_time.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm:ss"))));
        due_time.setText("hh:mm:ss");
        due_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                due_timeActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Task Name", "Date Deadline", "Time Deadline"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(124, 124, 124)
                        .addComponent(taskName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(99, 99, 99)
                        .addComponent(due_date))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(due_time)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(taskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(due_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(due_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnSimpan))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(527, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = cn.createStatement();
            if (taskName.getText().equals("") || 
                    due_date.getText().equals("") ||
                    due_time.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong", "Validasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if ("Simpan".equals(btnSimpan.getText())) {
                String sql = "INSERT INTO biodata VALUES ('" + taskName.getText() + 
                    "' , '" + due_date.getText() +
                    "' , '" + due_time.getText() + "')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                Bersih();
                tampilData();
            }
            else{ 
                 String update = "UPDATE biodata SET due_date = '" + due_date.getText() +
                         "', due_time = '" + due_time.getText() + "' WHERE taskName = '" + taskName.getText() + "'";
                    st.executeUpdate(update);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                    Bersih();
                    tampilData();
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void taskNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taskNameActionPerformed

    private void due_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_due_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_due_timeActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
     if (taskName.getText().equals("")){
        JOptionPane.showConfirmDialog(null, "Silahkan pilih data yang akan dihapus !");
     }else{
         int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan ?","Konfirmasi", JOptionPane.YES_NO_OPTION);
         if (jawab == 0){
             try{
                 st = cn.createStatement();
                 String sql = "DELETE FROM biodata WHERE taskName = '" + taskName.getText() + "'";
                 st.executeUpdate (sql);
                 JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                 tampilData();
                 Bersih();
             }catch (Exception e){
                 JOptionPane.showMessageDialog(null, e);
             }
             
         }
     }    
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        taskName.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        due_date.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        due_time.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        
        btnSimpan.setText("ubah");
    }//GEN-LAST:event_tblDataMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        Bersih();
    }//GEN-LAST:event_btnBatalActionPerformed

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
            java.util.logging.Logger.getLogger(apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JFormattedTextField due_date;
    private javax.swing.JFormattedTextField due_time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField taskName;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables

    private long calculateDelay(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
