import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Gui_DeleteBooks extends javax.swing.JFrame {
    private LibrarianAction la = new LibrarianAction();
    private String email;
    private String password;
    private boolean check = true; //True no change, False change language
    private boolean language = true; //True to English, False to French
    private String fromLang = "en";
    private String toLang = "fr";

    /**
     * Creates new form Gui_DeleteBooks
     */
    public Gui_DeleteBooks() {
        initComponents();
    }
    public Gui_DeleteBooks(String email, String password, boolean check, boolean language) {
        this.check = check;
        this.language = language;
        initComponents();
        this.email = email;
        this.password = password;
    }

    private void initComponents() {

        if(check == false) {
            if(language == false) {
                fromLang = "en";
                toLang = "fr";
            } else {
                fromLang = "fr";
                toLang = "en";
            }
        }

        setTitle("eLibrarian");
        setSize(500,400);
        setLocationRelativeTo(null);
        setResizable(false);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bookTitle_textbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        if(check == false) {
            try {
                String title = Gui_DeleteBooks.translate(fromLang, toLang, "Delete Library Books");
                title = URLDecoder.decode(new String(title.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel1.setText(title);

                jLabel2.setText(Gui_DeleteBooks.translate(fromLang, toLang,"Book Title:"));
                jButton1.setText(Gui_DeleteBooks.translate(fromLang, toLang,"Submit"));
                jButton2.setText(Gui_DeleteBooks.translate(fromLang, toLang,"Back"));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            jLabel1.setText("Delete Library Books");
            jLabel2.setText("Book Title:");
            jButton1.setText("Submit");
            jButton2.setText("Back");
        }
        

        bookTitle_textbox.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                bookTitle_textboxInputMethodTextChanged(evt);
            }
        });
        bookTitle_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitle_textboxActionPerformed(evt);
            }
        });

        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            // .addGroup(layout.createSequentialGroup()
                // .addGap(61, 61, 61)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100,100,100)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60,60,60))
                            // .addGroup(layout.createSequentialGroup()
                            //     .addGap(45, 45, 45)
                            //     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            //         .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        // .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            // .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            // .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bookTitle_textbox, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                            // .addGap(100,100,100)
                            .addContainerGap(95, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38,38,38))
                            
            // .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            //     .addGap(0, 0, Short.MAX_VALUE)
            //     .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            //     .addGap(35,35,35))
                
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bookTitle_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        pack();

    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbw_fxIpgQ1ZkisWUFeomdYYvM112EkwgaEMSXubKSE7U_m0E-R2VfknkPgEAx34CHfz/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    protected void jButton1ActionPerformed(ActionEvent evt) {
        String bookTitle = bookTitle_textbox.getText();
        la.setBookname(bookTitle);

        try {
            la.EditBookGUI(la.getBookname());
            try {
                String bookdelsuc = Gui_DeleteBooks.translate(fromLang, toLang,"Book successfully deleted!");
                bookdelsuc = URLDecoder.decode(new String(bookdelsuc.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                JOptionPane.showMessageDialog(this,bookdelsuc);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Gui_Registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gui_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void jButton2ActionPerformed(ActionEvent evt) {
        Gui_AdminMenu am = new Gui_AdminMenu(getEmail(), getPassword(), check, language);
        am.setVisible(true);
        dispose();
    }
    private String getEmail() {
        return email;
    }
    private String getPassword() {
        return password;
    }

    protected void bookTitle_textboxActionPerformed(ActionEvent evt) {
    }

    protected void bookTitle_textboxInputMethodTextChanged(InputMethodEvent evt) {
    }

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
            java.util.logging.Logger.getLogger(Gui_AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_DeleteBooks().setVisible(true);
            }
        });
    }

// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookTitle_textbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
// End of variables declaration//GEN-END:variables
}
