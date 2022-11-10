package View.Admin;

import Controller.BookManagementController;
import Controller.OracleDB;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class BookManagement {
    JPanel JPMain;
    private JTextField TFPublisher;
    private JTextField TFBookName;
    private JTextField TFAuthor;
    private JTextField TFBookID;
    private JLabel JLBookID;
    private JLabel JLBookName;
    private JLabel JLPublisher;
    private JLabel JLAuthor;
    private JTextField TFCategory;
    private JLabel JLCategory;
    private JButton JBDelete;
    private JButton JBUpdate;
    private JButton JBBack;
    private JButton JBAdd;

    public BookManagement(JFrame frame) {
        frame.setTitle("BookManagement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JBBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new AdminOperation(frame).JPMain);
            }
        });
        JBDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id= TFBookID.getText();
               OracleDB oracleDB = new OracleDB();
                if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "The book id can not be empty!");
                }else{
                    try {
                        ResultSet all = BookManagementController.getall(id, oracleDB);
                        if(!all.next()){
                            JOptionPane.showMessageDialog(null, "No records are found!");
                        }
                        else{
                            String author=all.getString( "Author" );
                            TFAuthor.setText(author);
                            String publisher=all.getString("Publisher");
                            TFPublisher.setText(publisher);
                            String category=all.getString("Category");
                            TFCategory.setText(category);
                            String name=all.getString("BookName");
                            TFBookName.setText(name);
                            BookManagementController.delete(id,oracleDB);
                        }
                    }catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                try {
                    oracleDB.closeConnection();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JBUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= TFBookID.getText();
                OracleDB oracleDB = new OracleDB();
                if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "The book id can not be empty!");
                }else{
                    try {
                        ResultSet all = BookManagementController.getall(id, oracleDB);
                        if(!all.next()){
                            JOptionPane.showMessageDialog(null, "No records are found!");
                        }
                        else{
                            String author=TFAuthor.getText();
                            String publisher= TFPublisher.getText();
                            String category = TFCategory.getText();
                            String name= TFBookName.getText();
                            if(author.equals("")||publisher.equals("")||category.equals("")||name.equals("")) {
                                JOptionPane.showMessageDialog(null, "Missing book information");

                            }else{
                                BookManagementController.update(id, oracleDB,publisher,author,name,category);
                            }
                        }
                    }catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                try {
                    oracleDB.closeConnection();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JBAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id= TFBookID.getText();
                OracleDB oracleDB = new OracleDB();
                if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "The book id can not be empty!");
                }else{
                    try {
                        ResultSet all = BookManagementController.getall(id, oracleDB);
                        if(!all.next()){
                            JOptionPane.showMessageDialog(null, "No records are found!");
                        }
                        else{
                            String author=TFAuthor.getText();
                            String publisher= TFPublisher.getText();
                            String category = TFCategory.getText();
                            String name= TFBookName.getText();
                            if(author.equals("")||publisher.equals("")||category.equals("")||name.equals("")) {
                                JOptionPane.showMessageDialog(null, "Missing book information");

                            }else{
                                try {
                                    BookManagementController.add(id, oracleDB, publisher, author, name, category);
                                }catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                try {
                    oracleDB.closeConnection();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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
        JPMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        JPMain.setBackground(new Color(-8806227));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(20, 20, 20, 20), -1, -1));
        panel1.setBackground(new Color(-7086643));
        panel1.setForeground(new Color(-460552));
        JPMain.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        TFPublisher = new JTextField();
        panel1.add(TFPublisher, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        JLPublisher = new JLabel();
        Font JLPublisherFont = this.$$$getFont$$$(null, -1, 16, JLPublisher.getFont());
        if (JLPublisherFont != null) JLPublisher.setFont(JLPublisherFont);
        JLPublisher.setForeground(new Color(-592138));
        JLPublisher.setText("Publisher");
        panel1.add(JLPublisher, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLAuthor = new JLabel();
        Font JLAuthorFont = this.$$$getFont$$$(null, -1, 16, JLAuthor.getFont());
        if (JLAuthorFont != null) JLAuthor.setFont(JLAuthorFont);
        JLAuthor.setForeground(new Color(-657931));
        JLAuthor.setText("Author");
        panel1.add(JLAuthor, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TFBookName = new JTextField();
        panel1.add(TFBookName, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        TFAuthor = new JTextField();
        panel1.add(TFAuthor, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        JLBookName = new JLabel();
        Font JLBookNameFont = this.$$$getFont$$$(null, -1, 16, JLBookName.getFont());
        if (JLBookNameFont != null) JLBookName.setFont(JLBookNameFont);
        JLBookName.setForeground(new Color(-789517));
        JLBookName.setText("Book Name");
        panel1.add(JLBookName, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JLBookID = new JLabel();
        Font JLBookIDFont = this.$$$getFont$$$(null, -1, 16, JLBookID.getFont());
        if (JLBookIDFont != null) JLBookID.setFont(JLBookIDFont);
        JLBookID.setForeground(new Color(-526345));
        JLBookID.setText("Book ID");
        panel1.add(JLBookID, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TFBookID = new JTextField();
        panel1.add(TFBookID, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        JLCategory = new JLabel();
        Font JLCategoryFont = this.$$$getFont$$$(null, -1, 16, JLCategory.getFont());
        if (JLCategoryFont != null) JLCategory.setFont(JLCategoryFont);
        JLCategory.setForeground(new Color(-460552));
        JLCategory.setText("Category");
        panel1.add(JLCategory, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TFCategory = new JTextField();
        TFCategory.setText("");
        panel1.add(TFCategory, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel2.setBackground(new Color(-6828067));
        JPMain.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JBDelete = new JButton();
        JBDelete.setBackground(new Color(-9017150));
        JBDelete.setText("Delete");
        panel2.add(JBDelete);
        JBAdd = new JButton();
        JBAdd.setBackground(new Color(-15022631));
        JBAdd.setText("Add");
        panel2.add(JBAdd);
        JBUpdate = new JButton();
        JBUpdate.setBackground(new Color(-13345850));
        JBUpdate.setText("Update");
        panel2.add(JBUpdate);
        JBBack = new JButton();
        JBBack.setBackground(new Color(-3374631));
        JBBack.setText("Back");
        panel2.add(JBBack);
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
