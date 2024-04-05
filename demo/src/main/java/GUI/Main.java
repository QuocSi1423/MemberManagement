package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Main extends JFrame {
  private Navigation navigation;
  private JPanel functionPanel;

  private void init() {
    this.setTitle("Quản lý thành viên");
    this.setSize(new Dimension(1250, 770));
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    navigation = new Navigation(this);

    functionPanel = new JPanel();
    functionPanel.setBackground(Color.WHITE);
    functionPanel.setPreferredSize(new Dimension(1050, 770));
    functionPanel.setLayout(null);

    JPanel p1 = new JPanel();
    p1.setBackground(Color.CYAN);
    p1.setPreferredSize(new Dimension(1050, 770));
    p1.setBounds(0,0,1050,770);
    functionPanel.add(p1);

    this.add(navigation, BorderLayout.WEST);
    this.add(functionPanel, BorderLayout.EAST);
    this.setVisible(true);
  }

  public Main() {
    init();
  }

  public void setFunction(JPanel functionPanel) {
    this.functionPanel.removeAll();
    this.functionPanel.add(functionPanel);
    this.revalidate();
    this.repaint();
  }

}
