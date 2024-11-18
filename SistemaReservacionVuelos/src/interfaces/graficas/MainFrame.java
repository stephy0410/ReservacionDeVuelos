package interfaces.graficas;

import javax.swing.*;
import java.awt.*;


class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MainFrame() {
        setTitle("Sistema de Reservación de Vuelos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Fondo con degradado
        JPanel backgroundPanel = createBackgroundPanel("Menú Principal");
        add(backgroundPanel);

        // Botones de navegación
        RoundedButton btnVuelos = new RoundedButton("Gestionar Vuelos");
        btnVuelos.setBounds(300, 120, 200, 50);
        btnVuelos.addActionListener(e -> openVueloFrame());
        backgroundPanel.add(btnVuelos);

        RoundedButton btnUsuarios = new RoundedButton("Gestionar Usuarios");
        btnUsuarios.setBounds(300, 200, 200, 50);
        btnUsuarios.addActionListener(e -> openUsuarioFrame());
        backgroundPanel.add(btnUsuarios);

        RoundedButton btnReservaciones = new RoundedButton("Gestionar Reservaciones");
        btnReservaciones.setBounds(300, 280, 200, 50);
        btnReservaciones.addActionListener(e -> openReservacionFrame());
        backgroundPanel.add(btnReservaciones);

        RoundedButton btnMetodosPago = new RoundedButton("Métodos de Pago");
        btnMetodosPago.setBounds(300, 360, 200, 50);
        btnMetodosPago.addActionListener(e -> openMetodoPagoFrame());
        backgroundPanel.add(btnMetodosPago);
    }

    // Métodos para abrir cada pantalla
    private void openVueloFrame() {
        SwingUtilities.invokeLater(VueloFrame::new);
    }

    private void openUsuarioFrame() {
        SwingUtilities.invokeLater(UsuarioFrame::new);
    }

    private void openReservacionFrame() {
        SwingUtilities.invokeLater(ReservacionFrame::new);
    }

    private void openMetodoPagoFrame() {
    	
        SwingUtilities.invokeLater(MetodoPagoFrame::new);
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
        backgroundPanel.setBounds(0, 0, 800, 600);

        JLabel title = new JLabel(titleText);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 28));
        title.setForeground(Color.WHITE);
        title.setBounds(150, 30, 500, 50);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(title);

        return backgroundPanel;
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
}






