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

public class Gui_BooksListInfo extends javax.swing.JFrame {
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
    

    public Gui_BooksListInfo() {
        initComponents();
    }
    private void initComponents() {

    }

    public Gui_BooksListInfo(String id, String email, String password, boolean check, boolean language) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        try {
            booklistinfo = b.inventoryInfoGUI(id);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18));

        if(check == false) {
            try {
                String title = Gui_BooksListInfo.translate(fromLang, toLang, booklistinfo.get(0));
                title = URLDecoder.decode(new String(title.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel1.setText(title);

                by = Gui_BooksListInfo.translate(fromLang, toLang,"by ");
                jLabel2.setText(by + booklistinfo.get(1));

                String desc = Gui_BooksListInfo.translate(fromLang, toLang,"Description: ");
                desc = URLDecoder.decode(new String(desc.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel3.setText(Gui_BooksListInfo.translate(fromLang, toLang,"Description: ")+ booklistinfo.get(2));

                String ava = Gui_BooksListInfo.translate(fromLang, toLang,"Availability: ");
                ava = URLDecoder.decode(new String(ava.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                jLabel4.setText(ava + booklistinfo.get(3));


                if(check == false) {
                    if(language == false) {
                        jLabel5.setText("Liste d'attente: "+ booklistinfo.get(4));
                        jButton2.setText("Emprunter / Rejoindre la liste d'attente");
                        jButton3.setText("Plus de détails sur le livre");
                    } else {
                        jLabel5.setText(waitlist + booklistinfo.get(4));
                        jButton2.setText("Borrow / Join Waitlist");
                        jButton3.setText("More Book Details");
                    }
                }

                jButton1.setText(Gui_BooksListInfo.translate(fromLang, toLang,"Back"));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            jLabel1.setText(booklistinfo.get(0));
            jLabel2.setText("by " + booklistinfo.get(1));
            jLabel3.setText("Description: " + booklistinfo.get(2));
            jLabel4.setText("Availability: " + booklistinfo.get(3));
            jLabel5.setText("Waitlist: " + booklistinfo.get(4));
            jButton1.setText("Back");
            jButton2.setText("Borrow / Join Waitlist");
            jButton3.setText("More Book Details");
        }

        setID(id);

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

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        ))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                        .addContainerGap(95, Short.MAX_VALUE)
                        )
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50,50,50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            ))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(458,458,458)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30,30,30)
                .addComponent(jLabel2)
                .addGap(35,35,35)
                .addComponent(jLabel3)
                .addGap(40,40,40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGap(70,70,70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
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
        Gui_BooksList bl = new Gui_BooksList(getEmail(), getPassword(), check, language);
        bl.setVisible(true);
        dispose();
    }
    private String getEmail() {
        return email;
    }
    private String getPassword() {
        return password;
    }

    protected void jButton2ActionPerformed(ActionEvent evt) {
        try {
            book.binfo(getID());
            // JOptionPane.showMessageDialog(this,book.getID());
            if(book.getAvailability()){
                book.changeAvailability(false, getID());
                try {
                    String bookbor = Gui_BooksListInfo.translate(fromLang, toLang,"Enjoy the book!\nIt is due back in 21 day(s).");
                    bookbor = URLDecoder.decode(new String(bookbor.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
                    JOptionPane.showMessageDialog(this,bookbor);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                try {
                    int wtime = book.getWL()*21;
                    book.changeWL(book.getWL()+1, getID());
                    try {
                        if(check == false) {
                            if(language == false) {
                                JOptionPane.showMessageDialog(this,"Merci d'avoir rejoint la liste d'attente. tu es le numéro" +book.getWL()+".\nLe temps d'attente estimé est "+wtime+" journées.");
                            } else {
                                JOptionPane.showMessageDialog(this,"Thank you for joining the waitlist. You are number " +book.getWL()+".\nThe estimated wait time is "+wtime+" day(s).");
                            }
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    private String getID() {
        return id;
    }
    private void setID(String id) {
        this.id = id;
    }

    protected void jButton3ActionPerformed(ActionEvent evt) {
        Gui_BookListInfoWiki bliw = new Gui_BookListInfoWiki(getID(), getEmail(), getPassword(), check, language);
        bliw.setVisible(true);
        dispose();
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
}
