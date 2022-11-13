import javax.swing.*;

public class JFrameDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                JFrameOne frame1 = new JFrameOne();
                frame1.show();
            }
        });
    }

}
