import javax.swing.*;

public class Principal {
    private JPanel panelPrincipal;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTable table1;

    public static void main(String[] args) {
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new Principal().panelPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }

