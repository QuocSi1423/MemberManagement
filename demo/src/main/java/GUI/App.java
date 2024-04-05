package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import BUS.ViolationBUS;
import Entity.Violation;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
  public static void printViolations(List<Violation> violations) {
        for (Violation violation : violations) {
            System.out.println("Violation ID: " + violation.getViolationId());
            System.out.println("Handling Type: " + violation.getHadlingType());
            System.out.println("Fine: " + violation.getFine());
            System.out.println("Handling Date: " + violation.getHandlingDate());
            System.out.println("Member ID: " + violation.getMemberId());
            System.out.println("Member Name: " + violation.getMember().getHoTen()); // Lấy thông tin tên của member từ entity Member
            System.out.println("---------------------------------------------");
        }
    }
  public static void main(String[] args) {
    FlatMacLightLaf.setup();
    ViolationBUS bus = new ViolationBUS();
    printViolations(bus.GetViolationListByFilter(null, null, null));


  }
}
