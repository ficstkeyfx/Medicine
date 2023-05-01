package view;

import UI.layout.DashBoard;
import UI.layout.Login;
import UI.layout.swing.GradientBackgroundPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashBoardView extends JFrame {
    
    JButton filter, search, add, edit, remove;
    
    public DashBoardView(){
        initComponent();
    }
    public void initComponent(){
        setSize(1000,600);
        setTitle("Medicine App");
        setLayout(new MigLayout("insets 0 0 0 0", "[center]", "[center]"));

//        GradientBackgroundPanel first = new GradientBackgroundPanel();
        Dash a = new Dash();
//        add(a, "push");
        
//        filter = a.getFilterBtn();
//        search = a.getSearchBtn();
//        add = a.getAddBtn();
//        edit = a.getEditBtn();
//        remove = a.getRemoveBtn();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng khi cửa số đóng
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    
//    public void addFilterListener(ActionListener listener){
//        filter.addActionListener(listener);
//    }
//
//    public void addSearchListener(ActionListener listener){
//        search.addActionListener(listener);
//    }
//    
//    public void addAddListener(ActionListener listener){
//        add.addActionListener(listener);
//    }
//    
//    public void addEditListener(ActionListener listener){
//        edit.addActionListener(listener);
//    }
//    public void addRemoveListener(ActionListener listener){
//        remove.addActionListener(listener);
//    }
//    public static void main(String[] args) {
//        new DashBoardView();
//    }
}
