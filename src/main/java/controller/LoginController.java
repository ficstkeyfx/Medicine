/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserModel;
import view.DashView;
import view.LoginView;

/**
 *
 * @author PV
 */
public class LoginController {
    private UserModel userModel;
    private LoginView loginView;
    private DashView dashBoardView;

    public LoginController(LoginView view) {
        UserModel user = view.getUserModel();
        this.loginView = view;
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    class LoginListener implements ActionListener{
        public LoginListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            UserModel user = loginView.getUserModel();
            System.out.println(user.getPassword());
            if ("1".equals(user.getUsername())&&"1".equals(user.getPassword())) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                dashBoardView = new DashView();
                DashBoardController dashBoardController = new DashBoardController(dashBoardView);
//                studentController.();
                loginView.setVisible(false);
                dashBoardView.setVisible(true);
            } else {
                loginView.showMessage("Tài khoản hoặc mật khẩu sai.");
            }
        }
    }
    
}
