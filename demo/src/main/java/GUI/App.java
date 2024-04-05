package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
  public static void main(String[] args) {
    FlatMacLightLaf.setup();
    new Main();
  }
}
