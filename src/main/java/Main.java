//import org.jdesktop.animation.timing.Animator;
import controller.LoginController;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        //        java.awt.EventQueue.invokeLater(new Runnable() {
        //            public void run() {
        //                new LoginApp();
        //            }
        //        });
        LoginView loginView = new LoginView();
        LoginController controller = new LoginController(loginView);
        // hiển thị màn hình login
        controller.showLoginView();
    }
}