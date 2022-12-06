import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Gui_BookSearch extends javax.swing.JFrame {
    private String email;
    private String password;
    private BookList b = new BookList();
    private String id = "";
    private boolean check = true; //True no change, False change language
    private boolean language = true; //True to English, False to French
    private String fromLang = "en";
    private String toLang = "fr";

    public Gui_BookSearch() {
        initComponents();
    }
    public Gui_BookSearch(String email, String password, boolean check, boolean language) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleorauthor_textbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        if(check == false) {
            try {
                String title = Gui_BookSearch.translate(fromLang, toLang,"Welcome to Book Search");
                title = URLDecoder.decode(new String(title.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel1.setText (title);

                String author = Gui_BookSearch.translate(fromLang, toLang,"Enter Title/Author:");
                author = URLDecoder.decode(new String(title.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel2.setText(author);

                jButton1.setText(Gui_BookSearch.translate(fromLang, toLang,"Next"));
                jButton2.setText(Gui_BookSearch.translate(fromLang, toLang,"Back"));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            jLabel1.setText("Welcome to Book Search");
            jLabel2.setText("Enter Title/Author:");
            jButton1.setText("Next");
            jButton2.setText("Back");
        }

        titleorauthor_textbox.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                titleorauthor_textboxInputMethodTextChanged(evt);
            }
        });
        titleorauthor_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleorauthor_textboxActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120,120,120)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50,50,50)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(titleorauthor_textbox, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))))   
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titleorauthor_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addGap(45,45,45))
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


    protected void titleorauthor_textboxActionPerformed(ActionEvent evt) {
    }

    protected void titleorauthor_textboxInputMethodTextChanged(InputMethodEvent evt) {
    }

    protected void jButton1ActionPerformed(ActionEvent evt) {
        String titleorauthor = titleorauthor_textbox.getText();
        if(!titleorauthor.isEmpty()){
            try {
                if(b.BookSearchGUI(titleorauthor)){
                    id = b.searchInventoryGUI(titleorauthor);
                    Gui_BookSearchInfo bsi = new Gui_BookSearchInfo(id, getEmail(), getPassword(), check, language);
                    bsi.setVisible(true);
                    dispose();
                } else {
                    try {
                        String searchbookfail = Gui_BookSearch.translate(fromLang, toLang,"We do not have any books matching "+titleorauthor+".\nPlease renter Title or Author.");
                        searchbookfail = URLDecoder.decode(new String(searchbookfail.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                        JOptionPane.showMessageDialog(this,searchbookfail);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }  
            } catch (Exception e){
               
            }
        } else {
            try {
                String notitle = Gui_BookSearch.translate(fromLang, toLang,"Please enter Title or Author.");
                notitle = URLDecoder.decode(new String(notitle.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                JOptionPane.showMessageDialog(this,notitle);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    protected void jButton2ActionPerformed(ActionEvent evt) {
        Gui_UserMenu um = new Gui_UserMenu(getEmail(), getPassword(), check, language);
        um.setVisible(true);
        dispose();
    }
    private String getEmail() {
        return email;
    }
    private String getPassword() {
        return password;
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
            java.util.logging.Logger.getLogger(Gui_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_BookSearch().setVisible(true);
            }
        });
}
    private javax.swing.JTextField titleorauthor_textbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
