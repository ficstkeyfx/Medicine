package UI.layout;

import UI.layout.swing.ButtonCus;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import model.UserModel;

public class Login extends JPanel {
    private ButtonCus SignInBtn;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
            jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12 ;
    private JPasswordField FieldPass;
    private JTextField FieldUser;

    public Login() {
        initComponents();
    }
    private void initComponents() {
        FieldPass = new JPasswordField();
        FieldUser = new JTextField();

        setMinimumSize(new Dimension(300, 600));
        setPreferredSize(new Dimension(300, 600));
        setMaximumSize(new Dimension(300, 600));

        setForeground(Color.WHITE);

        jLabel3 = new JLabel(new ImageIcon("src/main/java/UI/icon/pill.png"));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel1 = new JLabel("Đăng nhập");
        jLabel1.setFont(new Font("Calibri", 3, 24));
    //    jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel2 = new JLabel("Vui lòng đăng nhập để tiếp tục!");
    //    jLabel2.setForeground(Color.WHITE);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel4 = new JLabel("Username");
    //    jLabel4.setForeground(Color.WHITE);

        jLabel5 = new JLabel("__________________________________");
    //    jLabel5.setForeground(Color.WHITE);

        jLabel6 = new JLabel("Password");
    //    jLabel6.setForeground(Color.WHITE);

        jLabel7 = new JLabel("__________________________________");
    //    jLabel7.setForeground(Color.WHITE);

        jLabel8 = new JLabel(new ImageIcon("src/main/java/UI/icon/hidden.png"));
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);

    //    jLabel8.setForeground(Color.WHITE);

        jLabel9 = new JLabel(new ImageIcon("src/main/java/UI/icon/user.png"));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
    //    jLabel9.setForeground(Color.WHITE);

        SignInBtn = new ButtonCus();
        SignInBtn.setEffectColor(new Color(138, 115, 4));
        SignInBtn.setBackground(SignInBtn.getEffectColor());
        SignInBtn.setForeground(Color.WHITE);
        SignInBtn.setText("Login");
        SignInBtn.setFont(new java.awt.Font("Calibri", 3, 18));
        SignInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel10 = new JLabel("Don't have an account?");
    //    jLabel10.setForeground(Color.WHITE);

        jLabel11 = new JLabel("SignUp");
        jLabel11.setFont(new Font("Calibri", 1, 14));
        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setVerticalAlignment(SwingConstants.BOTTOM);
    //    jLabel11.setForeground(Color.WHITE);

        jLabel12 = new JLabel("Forgot password?");
        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
    //    jLabel12.setForeground(Color.WHITE);

        FieldUser.setOpaque(false);
        FieldUser.setFont(new Font("Calibri", 3, 18));
        FieldUser.setBorder(null);

        FieldPass.setOpaque(false);
        FieldPass.setFont(new Font("Calibri", 3, 18));
        FieldPass.setBorder(null);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100,100,100)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FieldUser, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20,20,20)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(FieldPass, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(220, 220, 220)
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(SignInBtn, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130,130,130)
                                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40,40,40)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5,5,5)
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(FieldUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(30,30,30)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(FieldPass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11,11,11)
                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel12)))
                                .addGap(19, 19, 19)
                                .addComponent(SignInBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(2, Short.MAX_VALUE))
        );

    }

    public ButtonCus getSignInBtn() {
        return SignInBtn;
    }
    
    public UserModel getUserModel(){
        return new UserModel(FieldUser.getText(),new String(FieldPass.getPassword()));
    }
}
