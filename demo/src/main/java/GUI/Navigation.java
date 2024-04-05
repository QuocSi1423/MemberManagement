package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Navigation extends JPanel implements ActionListener {

  private JButton scanBtn, memberBtn, equitmentBtn, borrowBtn, violatedBtn, reportBtn, ClickedBtn;
  private ImageIcon scanIcon, memberIcon, equitmentIcon, borrowIcon, violatedIcon, reportIcon;
  private JPanel buttons;
  private Main main;

  private void init() {

    scanBtn = new JButton("Ghi nhận");
    scanBtn.setPreferredSize(new Dimension(170, 60));
    scanIcon = new ImageIcon("demo/src/main/java/GUI/images/wscan.png");
    scanBtn.setIcon(scanIcon);
    scanBtn.setHorizontalAlignment(SwingConstants.LEFT);
    scanBtn.setBackground(new Color(0, 103, 254));
    scanBtn.setForeground(new Color(255, 255, 255));
    scanBtn.setOpaque(true);

    scanBtn.setFont(new Font("Helvetica", Font.BOLD, 16));

    memberBtn = new JButton("Thành viên");
    memberBtn.setPreferredSize(new Dimension(170, 60));
    memberIcon = new ImageIcon("demo/src/main/java/GUI/images/bmember.png");
    memberBtn.setIcon(memberIcon);
    memberBtn.setHorizontalAlignment(SwingConstants.LEFT);

    memberBtn.setFont(new Font("Helvetica", Font.BOLD, 16));

    equitmentBtn = new JButton("Thiết bị");
    equitmentBtn.setPreferredSize(new Dimension(170, 60));
    equitmentIcon = new ImageIcon("demo/src/main/java/GUI/images/bequi.png");
    equitmentBtn.setIcon(equitmentIcon);
    equitmentBtn.setHorizontalAlignment(SwingConstants.LEFT);

    equitmentBtn.setFont(new Font("Helvetica", Font.BOLD, 16));

    borrowBtn = new JButton("Mượn trả");
    borrowBtn.setPreferredSize(new Dimension(170, 60));
    borrowIcon = new ImageIcon("demo/src/main/java/GUI/images/bborrow.png");
    borrowBtn.setIcon(borrowIcon);
    borrowBtn.setHorizontalAlignment(SwingConstants.LEFT);

    borrowBtn.setFont(new Font("Helvetica", Font.BOLD, 16));

    violatedBtn = new JButton("Vi phạm");
    violatedBtn.setPreferredSize(new Dimension(170, 60));
    violatedIcon = new ImageIcon("demo/src/main/java/GUI/images/bvio.png");
    violatedBtn.setIcon(violatedIcon);
    violatedBtn.setHorizontalAlignment(SwingConstants.LEFT);

    violatedBtn.setFont(new Font("Helvetica", Font.BOLD, 16));

    reportBtn = new JButton("Thống kê");
    reportBtn.setPreferredSize(new Dimension(170, 60));
    reportIcon = new ImageIcon("demo/src/main/java/GUI/images/breport.png");
    reportBtn.setIcon(reportIcon);
    reportBtn.setHorizontalAlignment(SwingConstants.LEFT);

    reportBtn.setFont(new Font("Helvetica", Font.BOLD, 16));

    buttons = new JPanel();
    buttons.setBounds(15, 225, 170, 475);
    buttons.setPreferredSize(new Dimension(170, 475));
    buttons.setLayout(new FlowLayout());
    buttons.setBackground(Color.WHITE);
    buttons.add(scanBtn);
    buttons.add(memberBtn);
    buttons.add(equitmentBtn);
    buttons.add(borrowBtn);

    buttons.add(violatedBtn);
    buttons.add(reportBtn);

    ClickedBtn = scanBtn;
    scanBtn.addActionListener(this);
    memberBtn.addActionListener(this);
    equitmentBtn.addActionListener(this);
    borrowBtn.addActionListener(this);
    violatedBtn.addActionListener(this);
    reportBtn.addActionListener(this);

    this.add(buttons);
  }

  public Navigation(Main parent) {
    main = parent;
    this.setPreferredSize(new Dimension(200, 770));
    this.setBackground(Color.WHITE);
    this.setLayout(null);
    ImageIcon icon = createScaledImageIcon("demo/src/main/java/GUI/images/logo2.png", 0.3);
    JLabel lable = new JLabel(icon);
    lable.setBounds(25, 25, 150, 150);
    this.add(lable);
    init();
  }

  private static ImageIcon createScaledImageIcon(String path, double scale) {
    try {
      // Đọc hình ảnh từ tệp
      BufferedImage originalImage = ImageIO.read(new File(path));

      // Tính toán kích thước mới dựa trên tỷ lệ scale
      int newWidth = (int) (originalImage.getWidth() * scale);
      int newHeight = (int) (originalImage.getHeight() * scale);

      // Scale hình ảnh
      Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

      // Tạo một ImageIcon từ hình ảnh đã scale
      return new ImageIcon(scaledImage);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton clickedButton = (JButton) e.getSource();
    if (clickedButton == ClickedBtn) {
      return;
    }
    Icon icon = clickedButton.getIcon();
    ImageIcon image = (ImageIcon) icon;
    String path = image.getDescription();
    String[] dirs = path.split("/");
    dirs[dirs.length - 1] = "w" + dirs[dirs.length - 1].substring(1);
    String newPath = String.join("/", dirs);

    ImageIcon newImageIcon = new ImageIcon(newPath);
    clickedButton.setIcon(newImageIcon);

    clickedButton.setBackground(new Color(0, 103, 254));
    clickedButton.setForeground(new Color(255, 255, 255));
    ClickedBtn.setBackground(new Color(255, 255, 255));
    ClickedBtn.setForeground(new Color(0, 0, 0));

    icon = ClickedBtn.getIcon();
    image = (ImageIcon) icon;
    path = image.getDescription();
    dirs = path.split("/");
    dirs[dirs.length - 1] = "b" + dirs[dirs.length - 1].substring(1);
    newPath = String.join("/", dirs);

    newImageIcon = new ImageIcon(newPath);
    ClickedBtn.setIcon(newImageIcon);

    ClickedBtn = clickedButton;
    JPanel p1 = new JPanel();
    String functionText = clickedButton.getText();
    switch (functionText) {
      case "Ghi nhận":
        p1 = new JPanel();
        p1.setBackground(Color.CYAN);
        p1.setPreferredSize(new Dimension(1050, 770));
        p1.setBounds(0,0,1050,770);
        main.setFunction(p1);
        break;

      case "Thành viên":
        p1 = new JPanel();
        p1.setBackground(Color.GREEN);
        p1.setPreferredSize(new Dimension(1050, 770));
        p1.setBounds(0,0,1050,770);
        main.setFunction(p1);
        break;
      case "Thiết bị":
        p1 = new JPanel();
        p1.setBackground(Color.GRAY);
        p1.setPreferredSize(new Dimension(1050, 770));
        p1.setBounds(0,0,1050,770);
        main.setFunction(p1);
        break;
      case "Mượn trả":
        p1 = new JPanel();
        p1.setBackground(Color.YELLOW);
        p1.setPreferredSize(new Dimension(1050, 770));
        p1.setBounds(0,0,1050,770);
        main.setFunction(p1);
        break;
      case "Vi phạm":
        p1 = new JPanel();
        p1.setBackground(Color.BLUE);
        p1.setPreferredSize(new Dimension(1050, 770));
        p1.setBounds(0,0,1050,770);
        main.setFunction(p1);
        break;
      case "Thống kê":
        p1 = new JPanel();
        p1.setBackground(Color.PINK);
        p1.setPreferredSize(new Dimension(1050, 770));
        p1.setBounds(0,0,1050,770);
        main.setFunction(p1);
        break;
      default:
        break;
    }

  }
}
