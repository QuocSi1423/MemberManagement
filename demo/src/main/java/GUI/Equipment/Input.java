/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Equipment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Input extends JTextField implements FocusListener {
    private String placeHolder = "";

    public void initEvent() {
        this.addFocusListener(this);
        this.setForeground(Color.GRAY);
    }

    public Input(String placeHolder) {
        super();
        this.initEvent();
        this.setForeground(Color.GRAY);
        this.placeHolder = placeHolder;
        this.setText(placeHolder);
    }
    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().equals(placeHolder)) {
            this.setText("");
            this.setForeground(new Color(0,0,0));
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().equals("")) {
            this.setText(placeHolder);
            this.setForeground(Color.GRAY);
        }
    }  
}
