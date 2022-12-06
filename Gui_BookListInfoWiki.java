import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Gui_BookListInfoWiki extends javax.swing.JFrame {
    private String email;
    private String password;
    private BookList b = new BookList();
    private ArrayList<String> booklistinfo =new ArrayList<String>();
    private String id = "";
    private Book book = new Book();
    private boolean check = true; //True no change, False change language
    private boolean language = true; //True to English, False to French
    private String fromLang = "en";
    private String toLang = "fr";
    private String by  = "by ";
    private String waitlist = "Waitlist: ";
    private Jwiki jwiki1;
    private Jwiki jwiki2;

    public Gui_BookListInfoWiki() {
        initComponents();
    }
    private void initComponents() {

    }

    public Gui_BookListInfoWiki(String id, String email, String password, boolean check, boolean language) {
        this.check = check;
        this.language = language;
        initComponents(id);
        this.email = email;
        this.password = password;
    }

    private void initComponents(String id) {

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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        try {
            booklistinfo = b.inventoryInfoGUI(id);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        jwiki1 = new Jwiki(""+booklistinfo.get(0));
        jwiki2 = new Jwiki(""+booklistinfo.get(1));

        if(check == false) {
            try {
                String title = Gui_BookListInfoWiki.translate(fromLang, toLang, ""+jwiki1.getExtractText());
                title = URLDecoder.decode(new String(title.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel1.setText(title);

                by = Gui_BookListInfoWiki.translate(fromLang, toLang,""+jwiki2.getExtractText());
                jLabel2.setText(by);

                jButton1.setText(Gui_BookListInfoWiki.translate(fromLang, toLang,"Back"));

            } catch (Exception e) {
                jLabel1.setText(booklistinfo.get(0));
                jLabel2.setText("by" + ""+booklistinfo.get(1));
                
            }
        } else {
            try{
                jLabel1.setText(""+jwiki1.getExtractText());
                jButton1.setText("Back");
                jLabel2.setText("" +jwiki2.getExtractText());
            } catch (Exception e) {
                jLabel1.setText(booklistinfo.get(0));
                jButton1.setText("Back");
                jLabel2.setText("by" +booklistinfo.get(1));
            }
        }

        setID(id);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        )
                        .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        )
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30,30,30)
                .addComponent(jLabel2)
                .addGap(40,40,40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1))
                .addGap(23, 23, 23))
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
        Gui_BooksListInfo bli = new Gui_BooksListInfo(getID(),getEmail(), getPassword(), check, language);
        bli.setVisible(true);
        dispose();
    }
    private String getEmail() {
        return email;
    }
    private String getPassword() {
        return password;
    }

    private String getID() {
        return id;
    }
    private void setID(String id) {
        this.id = id;
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
                new Gui_BooksListInfo().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}