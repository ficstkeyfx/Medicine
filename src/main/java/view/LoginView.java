package view;

import UI.layout.swing.GradientBackgroundPanel;
import UI.layout.Login;
import UI.layout.swing.ButtonCus;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserModel;

public class LoginView extends JFrame implements ActionListener{
//    private LoginAndRegister logRes;
    Login a;
    JButton signInButton;
    public LoginView(){
        initComponent();
    }
    public void initComponent(){
        setSize(1000,600);
        setTitle("Medicine App");
        setLayout(new MigLayout("insets 0 0 0 0", "[]0[]", "push[center][center]push"));

        GradientBackgroundPanel first = new GradientBackgroundPanel();
        first.setLayout(new MigLayout("wrap", "push[center]push", "push[]10[]push"));
        first.setMinimumSize(new Dimension(695,600));
        first.setPreferredSize(new Dimension(695,600));
        first.setMaximumSize(new Dimension(695,600));
        JLabel nameApp = new JLabel("MEDICINE MANAGER APP");
        nameApp.setFont(new Font("Calibri", 1, 50));
        nameApp.setHorizontalAlignment(SwingConstants.CENTER);
        first.add(nameApp);

        JLabel desApp = new JLabel("Ứng dụng quản lý vật tư, thuốc của nhà thuốc");
        desApp.setSize(new Dimension());
        desApp.setFont(new Font("Calibri", 2, 18));
        desApp.setHorizontalAlignment(SwingConstants.CENTER);
        first.add(desApp);
        add(first, "w 50%");

        a = new Login();
        a.setBackground(new Color(248, 244, 202));
        add(a, "wrap");


        signInButton = a.getSignInBtn();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng khi cửa số đóng
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
    
    public UserModel getUserModel(){
        return a.getUserModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public void addLoginListener(ActionListener listener) {
        signInButton.addActionListener(listener);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
