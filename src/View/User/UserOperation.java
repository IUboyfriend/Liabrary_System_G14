package View.User;

import Controller.LoginController;
import View.Initial;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;

public class UserOperation {
    private JPanel JPHead;
    private JLabel JLWelcomeUser;
    private JButton JBLogout;
    private JPanel JPButtons;
    private JButton JBMyBook;
    private JButton JBSearch;
    private JLabel JTVIP;
    private JPanel JPVIP;
    public JPanel JPMain;

    public UserOperation(JFrame frame) {
        frame.setTitle("User Operation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 160);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        try {
            JLWelcomeUser.setText("Welcome, " + LoginController.getNickName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        JBLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete the cookie, return to the initial interface
                frame.setContentPane(new Initial(frame).JPMain);
            }
        });
        JBMyBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setContentPane(new MyBookBorrow(frame).JPMain);
            }
        });
        JBSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new SearchBook(frame).JPMain);
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JPMain = new JPanel();
        JPMain.setLayout(new BorderLayout(0, 0));
        JPHead = new JPanel();
        JPHead.setLayout(new GridBagLayout());
        JPHead.setBackground(new Color(-7086643));
        JPMain.add(JPHead, BorderLayout.NORTH);
        JPHead.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(-4473925)));
        JLWelcomeUser = new JLabel();
        Font JLWelcomeUserFont = this.$$$getFont$$$("Arial Black", -1, 20, JLWelcomeUser.getFont());
        if (JLWelcomeUserFont != null) JLWelcomeUser.setFont(JLWelcomeUserFont);
        JLWelcomeUser.setForeground(new Color(-394759));
        JLWelcomeUser.setText("Welcome, Jay!");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 5, 150);
        JPHead.add(JLWelcomeUser, gbc);
        JBLogout = new JButton();
        JBLogout.setEnabled(true);
        Font JBLogoutFont = this.$$$getFont$$$("Arial", -1, 12, JBLogout.getFont());
        if (JBLogoutFont != null) JBLogout.setFont(JBLogoutFont);
        JBLogout.setForeground(new Color(-9737365));
        JBLogout.setHorizontalTextPosition(11);
        JBLogout.setText("Logout");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        JPHead.add(JBLogout, gbc);
        JPButtons = new JPanel();
        JPButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        JPButtons.setBackground(new Color(-6828067));
        JPButtons.setForeground(new Color(-6828067));
        JPMain.add(JPButtons, BorderLayout.SOUTH);
        JPButtons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        JBMyBook = new JButton();
        JBMyBook.setActionCommand("");
        JBMyBook.setAutoscrolls(false);
        JBMyBook.setBackground(new Color(-9017150));
        JBMyBook.setEnabled(true);
        JBMyBook.setForeground(new Color(-1907998));
        JBMyBook.setText("My Book");
        JPButtons.add(JBMyBook);
        JBSearch = new JButton();
        JBSearch.setBackground(new Color(-15022631));
        JBSearch.setForeground(new Color(-789517));
        JBSearch.setText("Search Book");
        JPButtons.add(JBSearch);
        JPVIP = new JPanel();
        JPVIP.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPVIP.setBackground(new Color(-6647090));
        JPMain.add(JPVIP, BorderLayout.CENTER);
        JTVIP = new JLabel();
        JTVIP.setText("Your VIP score is 20. You are now our VIP user.");
        JPVIP.add(JTVIP);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPMain;
    }
}
