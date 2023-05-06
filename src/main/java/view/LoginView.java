package view;

import UI.layout.swing.GradientBackgroundPanel;
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
        setTitle("Medicine Manage");
        setLayout(new MigLayout("insets 0 0 0 0", "[]0[]", "push[center][center]push"));

        GradientBackgroundPanel first = new GradientBackgroundPanel(new Color(154, 125, 222),new Color(236, 225, 152));
        first.setLayout(new MigLayout("wrap", "push[center]push", "push[]10[]push"));
        first.setMinimumSize(new Dimension(695,600));
        first.setPreferredSize(new Dimension(695,600));
        first.setMaximumSize(new Dimension(695,600));
        JLabel nameApp = new JLabel("MEDICINE MANAGE");
        nameApp.setFont(new Font("Calibri", 1, 50));
        nameApp.setHorizontalAlignment(SwingConstants.CENTER);
        first.add(nameApp);

        JLabel desApp = new JLabel("Quản lý thuốc");
        desApp.setSize(new Dimension());
        desApp.setFont(new Font("Calibri", 2, 18));
        desApp.setHorizontalAlignment(SwingConstants.CENTER);
        a = new Login();
        a.setBackground(new Color(154, 125, 222));
        add(a, "w 50%");
        first.add(desApp);
        add(first,"wrap" );

        


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
