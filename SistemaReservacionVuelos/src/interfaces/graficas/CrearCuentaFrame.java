package interfaces.graficas;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearCuentaFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public CrearCuentaFrame() {
        setTitle("Crear Cuenta");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Fondo con degradado
        JPanel backgroundPanel = createBackgroundPanel("Crear Cuenta");
        add(backgroundPanel);

        // Campos de texto y etiquetas
        JLabel lblNombre = createLabel("Nombre:");
        lblNombre.setBounds(100, 100, 150, 30);
        backgroundPanel.add(lblNombre);

        JTextField txtNombre = createTextField();
        txtNombre.setBounds(250, 100, 200, 30);
        backgroundPanel.add(txtNombre);

        JLabel lblCorreo = createLabel("Correo:");
        lblCorreo.setBounds(100, 150, 150, 30);
        backgroundPanel.add(lblCorreo);

        JTextField txtCorreo = createTextField();
        txtCorreo.setBounds(250, 150, 200, 30);
        backgroundPanel.add(txtCorreo);

        JLabel lblPassword = createLabel("Contraseña:");
        lblPassword.setBounds(100, 200, 150, 30);
        backgroundPanel.add(lblPassword);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(250, 200, 200, 30);
        txtPassword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        backgroundPanel.add(txtPassword);

        JLabel lblConfirmPassword = createLabel("Confirmar Contraseña:");
        lblConfirmPassword.setBounds(100, 250, 150, 30);
        backgroundPanel.add(lblConfirmPassword);

        JPasswordField txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(250, 250, 200, 30);
        txtConfirmPassword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        backgroundPanel.add(txtConfirmPassword);

        // Botón Crear Cuenta
        RoundedButton btnCrearCuenta = new RoundedButton("Crear Cuenta");
        btnCrearCuenta.setBounds(150, 350, 200, 50);
        btnCrearCuenta.addActionListener(e -> {
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            if (txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            Connection connection = null;
            	try {
            		
                	// Database connectjdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true
                	// Conectamos con la base de datos
            		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Brownie5");
					final String SQL_INSERT = "INSERT INTO CLIENTE (usuario, nombre, email,contraseña) VALUES (?,?,?,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
					preparedStatement.setString(1, txtNombre.getText());
					preparedStatement.setString(2, txtNombre.getText());
					preparedStatement.setString(3, txtCorreo.getText());
					preparedStatement.setString(4, txtPassword.getPassword().toString());
					int row = preparedStatement.executeUpdate();
					if(row > 0) {
						JOptionPane.showMessageDialog(this, "Cuenta creada exitosamente.");
						dispose();
					}
					connection.close();
				} catch (SQLException e1) {
					try {
						connection.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					JOptionPane.showMessageDialog(this, "Error  inesperado "+ e1.getMessage());
				}
                
            
        });
        backgroundPanel.add(btnCrearCuenta);

        // Botón de Regresar
        RoundedButton btnRegresar = new RoundedButton("Regresar");
        btnRegresar.setBounds(150, 420, 200, 50);
        btnRegresar.addActionListener(e -> dispose());
        backgroundPanel.add(btnRegresar);

        // Hacer visible la ventana
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Métodos auxiliares
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return textField;
    }
 // Clase personalizada para crear botones redondeados
    private static class RoundedButton extends JButton {
        private static final long serialVersionUID = 1L;

        public RoundedButton(String text) {
            super(text);
            setFont(new Font("Arial", Font.BOLD, 16));
            setForeground(Color.WHITE);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Fondo del botón
            g2.setColor(new Color(142, 45, 226));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

            // Hover del botón
            if (getModel().isRollover()) {
                g2.setColor(new Color(74, 0, 224));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }

            // Texto del botón
            super.paintComponent(g2);
        }

        @Override
        public void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
    private JPanel createBackgroundPanel(String titleText) {
        JPanel backgroundPanel = new JPanel(null) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new java.awt.GradientPaint(0, 0, new Color(74, 0, 224), 0, getHeight(), new Color(142, 45, 226)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBounds(0, 0, 500, 500);

        JLabel title = new JLabel(titleText);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 20, 500, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(title);

        return backgroundPanel;
    }
}


