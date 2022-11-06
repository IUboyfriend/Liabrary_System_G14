import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public static void main(String[] args) {
        JFrame Login_frame = new JFrame("Login");
        Login_frame.setSize(350, 220);
        Login_frame.setLocation(600, 300);
        Login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        Login_frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(30, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(120, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(130, 90, 80, 25);
        panel.add(loginButton);

        String username = userText.getText();
        String password = new String(passwordText.getPassword());
        //System.out.print(username + "  "+ password);

        JLabel statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setBounds(50, 130, 160, 25);
        panel.add(statusLabel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "用户名： " + username;
                data += ", 密码: " + password;
                statusLabel.setText(data);
            }
        });
        Login_frame.setVisible(true);
    }
}
