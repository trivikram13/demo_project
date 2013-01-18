/*

A simple java application to produce graphs based on
connectivity of english words.

On run enter number of nodes or words in the graph
then enter each word one by one and finally click Draw Graph

If any two words differs only by difference of one character
then an edge will connect them


Submitted By: Anurag Saini UG201010004

*/


package pkg.graph;

import java.awt.Color;
import javax.swing.JFrame;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        this.setLocation(400, 300);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter number of nodes:");

        jButton1.setText("Clear Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addGap(0, 266, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    String[] nodeName;
    int size = 0, gotWords = 0; 
    String mode = "getSize"; 
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nodeName = null;
        jLabel1.setText("Enter number of nodes");
        jButton2.setText("Enter");
        jTextField1.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String S = jTextField1.getText();
        if(mode.equals("getSize")){
            size = this.str2num(S);
            if(size != 0){
                nodeName = new String[size];
                mode = "getWords";
                jLabel1.setText("Enter Word - " + (gotWords + 1)); jTextField1.setText("");
            }
            else{
                jTextField1.setText("Invalid input");
            }
        }
        else if(mode.equals("getWords")){
            if(gotWords == size - 1){
                mode = "drawGraph";
                nodeName[gotWords] = S;
                gotWords++;
                jTextField1.setText("");
                jTextField1.setEnabled(false);
                jButton2.setText("Draw Graph");
                jLabel1.setText("Click to draw graph");
            }
            else{
                if(S.equals("")){ jTextField1.setText("All nodes not entered"); }
                else{
                    nodeName[gotWords] = S;
                    gotWords++;
                    jTextField1.setText("");
                    jLabel1.setText("Enter Word - " + (gotWords + 1));
                }
            }
        }
        else{
            jLabel1.setText("Enter number of nodes");
            jButton2.setText("Enter"); jTextField1.setText("");
            jTextField1.setEnabled(true);
            this.drawGraph();
            mode = "getSize";
            gotWords = 0;
            nodeName = null;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void drawGraph(){
        myCanvas c = new myCanvas(nodeName);
        JFrame f = new JFrame();
        
        c.setBackground(Color.WHITE);
        c.setSize(400, 400);
        f.setSize(400, 400);
        f.setLocation(600, 200);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.getContentPane().add(c);

        f.setVisible(true);
    }
    
    private int str2num(String S){
        int num = 0, i = 0; boolean valid = true;
        while(i < S.length() && valid){
            if(S.charAt(i) < '0' || S.charAt(i) > '9'){ valid = false; }
            num = num*10 + (S.charAt(i) - '0'); i++;
        }
        if(valid){ return num; }
        return 0;
    }
    
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
