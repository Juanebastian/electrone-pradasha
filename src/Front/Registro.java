
package Front;

import javax.swing.JOptionPane;
import Back.LoginCrud;
import Back.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.ImageIcon;
/** 
 * <b>CLASE:</b> Registro.java 
 * <b>OBJETIVO:</b> Proporcional al usuario una interfaz para registrarse al aplicativo.
 * PROYECTO : ElectronePradasha
 *
 * @version 1.0, 03 de mayo del 2025 
 * @author Sebastian Diaz
 */
public class Registro extends javax.swing.JFrame {
    
    
    
Usuario lg = new Usuario();
    LoginCrud login = new LoginCrud();
    public Registro() {
        // Set the title and icon for the JFrame.
        setTitle("--ELECTRONE PRADASHA--");
        setIconImage(new ImageIcon(getClass().getResource("/Img/boss.png")).getImage());
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        txtCorreo.setText("@sanmateo.edu.co");
       // txtPass.setText("1234");
    }

    
    /** 
     * <b>RegistrarProveedor()</b>
     * <b>OBJETIVO:</b>Validar que el usuario y contraseña ingresados cumplan los requisitos.
     *
     */
    public void validar(){
            String correo = txtCorreo.getText();
            String pass = String.valueOf(txtPass.getPassword());
            String pass2 = String.valueOf(txtPass2.getPassword());
            String nom = txtNombres.getText();
            String ape = txtApellidos.getText();
            String rol = cbxRol.getSelectedItem().toString();
            
            int largo;
            boolean ban1;
            boolean ban2;
            boolean ban3;
            boolean ban4;
//-------------------------------------------------------------------------------------

            largo = correo.length();
            char[] miCorreo = correo.toCharArray();

            ban1 = false;
            ban2 = false;
            ban3 = false;
            for (int i = 0; i < largo; i++) {
                if (miCorreo[i] == '.') {
                    ban1 = true;
                }

                if (miCorreo[i] == '@') {
                    ban2 = true;
                }
            }

            if (ban1 && ban2) {
             //   JOptionPane.showMessageDialog(null, "THE EMAIL DOES MEET THE REQUIREMENTS");
                ban3 = true;
            } else {
                JOptionPane.showMessageDialog(null, "THE EMAIL DOES NOT MEET THE REQUIREMENTS");
                // Aquí puedes decidir si quieres salir del bucle o permitir al usuario corregir el correo.

            }

//-------------------------------------------------------------------------------------
        ban4 = false;    
        if(pass.equals(pass2)){
                ban4 = true;
            }
            if(ban4){
            //   JOptionPane.showMessageDialog(null, "PASSWORDS IF THEY MATCH");
            }else{

                JOptionPane.showMessageDialog(null, "PASSWORDS DO NOT MATCH");
            }

                if (ban3 == true && ban4 == true) {
                    
                    
                    String hashedPassword = hashPassword(pass);
                    lg.setPass(hashedPassword);
                    lg.setNombres(nom);
                    //lg.setPass(pass);
                    lg.setCorreo(correo);
                    lg.setApellidos(ape);
                    lg.setRol(rol);

                    int pregunta = JOptionPane.showConfirmDialog(null, "Personal data protection\n" +
                    "Personal Data Protection Law or Law 1581 of 2012\n" +
                    "\n" +
                    "Recognizes and protects the right that all people have to know, update and " +"\n" + 
                    "rectify the information that has been collected about them in databases or files" +"\n" + 
                     " that are susceptible to treatment by entities of a public or private nature.\n" +" ");
                    if (pregunta == 0) {
                         login.Registrar(lg);

                        Login iniciar = new Login();
                        iniciar.setVisible(true);
                        dispose();
                         JOptionPane.showMessageDialog(null, "REGISTERED USER");
                    }

                }    
        
     
    }//Fin metodo validar
    
    /** 
     * <b>hashPassword()</b>
     * <b>OBJETIVO:</b>Encritrtar con un hash la contraseña del usuario.
     *
     * @param password Objeto Proveedor que contiene la información del nuevo proveedor.
     * @return password contraseña encryptada.
     */
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }//Fin metodo hashPassword

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtCorreo = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        cbxRol = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnIniciar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        txtCorreo.setBackground(new java.awt.Color(204, 204, 204));
        txtCorreo.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        btnIniciar.setBackground(new java.awt.Color(204, 204, 204));
        btnIniciar.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(0, 102, 102));
        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/user2.png"))); // NOI18N
        btnIniciar.setText("REGISTER");
        btnIniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(204, 204, 204));
        txtPass.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EMAIL");

        txtNombres.setBackground(new java.awt.Color(204, 204, 204));
        txtNombres.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");

        txtApellidos.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidos.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        cbxRol.setBackground(new java.awt.Color(204, 204, 204));
        cbxRol.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WAREHOUSE MANAGER", "SALES MANAGER", "WAREHOUSE ASSISTANT", "SALES ASSISTANT" }));

        jLabel5.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAME");

        jLabel6.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LAST NAME");

        jLabel7.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ROLE");

        jLabel9.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CONFIRM PASS");

        txtPass2.setBackground(new java.awt.Color(204, 204, 204));
        txtPass2.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbxRol, 0, 221, Short.MAX_VALUE)
                        .addComponent(txtApellidos)
                        .addComponent(txtPass)
                        .addComponent(txtCorreo)
                        .addComponent(txtNombres)
                        .addComponent(txtPass2))
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(btnIniciar)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel8.setFont(new java.awt.Font("Utopia", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/boss.png"))); // NOI18N
        jLabel8.setText("REGISTER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(104, 104, 104))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoep2.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIniciar1.setBackground(new java.awt.Color(204, 204, 204));
        btnIniciar1.setFont(new java.awt.Font("Utopia", 1, 14)); // NOI18N
        btnIniciar1.setForeground(new java.awt.Color(0, 102, 102));
        btnIniciar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/1486485553-ago-arrow-arrow-left-back-previous-direction-left_81160.png"))); // NOI18N
        btnIniciar1.setText("BACK");
        btnIniciar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59)
                .addComponent(btnIniciar1)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIniciar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        // TODO add your handling code here:
        validar();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnIniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar1ActionPerformed
        // TODO add your handling code here:
        Login iniciar = new Login();
                        iniciar.setVisible(true);
                        dispose();
    }//GEN-LAST:event_btnIniciar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnIniciar1;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables
}//fin clase Registrar
