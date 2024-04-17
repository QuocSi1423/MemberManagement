package GUI;

import javax.swing.JFrame;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1050, 840);
        member_layout test = new member_layout();
        frame.add(test);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
