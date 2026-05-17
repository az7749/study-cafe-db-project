package screen;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class LoginScreen extends JFrame {
    private static final Color BACKGROUND = new Color(239, 243, 249);
    private static final Color BORDER = new Color(214, 221, 232);
    private static final Color PRIMARY = new Color(43, 105, 201);
    private static final Color SECONDARY = new Color(222, 235, 255);
    private static final Color TEXT = new Color(31, 41, 55);

    public LoginScreen() {
        setTitle("\uc2a4\ud130\ub514\uce74\ud398 \ud68c\uc6d0 \ud504\ub85c\uadf8\ub7a8");
        setSize(520, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBackground(BACKGROUND);
        setContentPane(root);

        JPanel content = new JPanel(new BorderLayout(0, 18));
        content.setOpaque(false);
        content.add(createHeader(), BorderLayout.NORTH);
        content.add(createLoginBox(), BorderLayout.CENTER);

        root.add(content);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new GridBagLayout());
        header.setOpaque(false);

        JLabel title = new JLabel("\uc2a4\ud130\ub514\uce74\ud398 \ud68c\uc6d0 \ud504\ub85c\uadf8\ub7a8", SwingConstants.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 18));
        title.setForeground(TEXT);

        JLabel subtitle = new JLabel("\ud68c\uc6d0 \ub85c\uadf8\uc778 \ud6c4 \uc774\uc6a9\uad8c \uad6c\ub9e4, \uc88c\uc11d \uc774\uc6a9, \ub0b4\uc5ed \uc870\ud68c \uac00\ub2a5", SwingConstants.CENTER);
        subtitle.setFont(new Font("Dialog", Font.PLAIN, 11));
        subtitle.setForeground(new Color(100, 116, 139));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        header.add(title, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 0);
        header.add(subtitle, gbc);

        return header;
    }

    private JPanel createLoginBox() {
        JPanel box = new JPanel(new GridBagLayout());
        box.setBackground(Color.WHITE);
        box.setPreferredSize(new Dimension(220, 142));
        box.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(20, 22, 14, 22)
        ));

        JLabel phoneLabel = createLabel("\uc804\ud654\ubc88\ud638");
        JTextField phoneField = createTextField("010-0000-0000");

        JLabel passwordLabel = createLabel("\ube44\ubc00\ubc88\ud638");
        JPasswordField passwordField = createPasswordField();

        JButton loginButton = createButton("\ub85c\uadf8\uc778", PRIMARY, Color.WHITE);
        JButton signupButton = createButton("\ud68c\uc6d0\uac00\uc785", SECONDARY, PRIMARY);
        JLabel findPassword = createLinkLabel("\ube44\ubc00\ubc88\ud638 \ucc3e\uae30");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        box.add(phoneLabel, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 12, 0);
        box.add(phoneField, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        box.add(passwordLabel, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(5, 0, 12, 0);
        box.add(passwordField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.insets = new Insets(0, 0, 0, 4);
        box.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 4, 0, 0);
        box.add(signupButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        box.add(findPassword, gbc);

        return box;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Dialog", Font.PLAIN, 11));
        label.setForeground(TEXT);
        return label;
    }

    private JTextField createTextField(String text) {
        JTextField field = new JTextField(text);
        field.setFont(new Font("Dialog", Font.PLAIN, 12));
        field.setForeground(new Color(148, 163, 184));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        return field;
    }

    private JPasswordField createPasswordField() {
        JPasswordField field = new JPasswordField("password");
        field.setFont(new Font("Dialog", Font.PLAIN, 12));
        field.setForeground(new Color(148, 163, 184));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        return field;
    }

    private JButton createButton(String text, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setFont(new Font("Dialog", Font.BOLD, 11));
        button.setForeground(foreground);
        button.setBackground(background);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(7, 18, 7, 18));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JLabel createLinkLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Dialog", Font.BOLD, 11));
        label.setForeground(PRIMARY);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return label;
    }
}
