import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;

import org.w3c.dom.events.Event;

public class JFrameOne implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public JFrameOne() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        this.frame.setTitle("JFrameOne");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(500,400);
        this.frame.setLocationRelativeTo(null);
        // this.frame.setResizable(false);
       
        panel = new JPanel();
        // panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        panel.setBackground(Color.RED);

        // for(int i = 1; i <= 2; i++) {
        // JButton button = new JButton("Button" + Integer.toString(i));
        // button.setBounds(50, 50, 50, 50);
        // panel.add(button);
        // }

        // JButton button3 = new JButton("Button3");
        // button3.setBounds(50, 50, 50, 50);
        // panel.add(button3);

        // JButton button4 = new JButton("Button4");
        // button4.setBounds(50, 50, 50, 50);
        // panel.add(button4);
        
        label = new JLabel("Hi dllm onlun9");
        panel.add(label);

        label.setForeground(Color.white);

        label.setFont(new Font("Sans-serif", Font.BOLD, 36));


        button = createButton();
        panel.add(button);


        panel.setPreferredSize(new DimensionUIResource(250, 100));

        frame.add(panel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        // frame.add(panel, BorderLayout.NORTH);

    }

    private JButton createButton() {
        JButton button = new JButton("Print");
        button.setFocusable(false);

        button.setToolTipText("Click this");

        button.setFont(new Font("Arial", Font.PLAIN, 24));

        button.setMargin(new InsetsUIResource(10, 10, 10, 10));

        button.addActionListener(this);

        // button.setEnabled(false);

        // button.doClick();

        button.setPreferredSize(new DimensionUIResource(200, 75));

        button.setMnemonic('P');

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Print button has been clicked");
        label.setText("<html>Hi dllm onlun9 <br> 1679 pk</html>");
    }

    public void show() {
        this.frame.setVisible(true);
    }
}
