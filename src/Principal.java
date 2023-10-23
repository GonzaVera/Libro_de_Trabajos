import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Principal {
    private JPanel panelPrincipal;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTable table1;


    public Principal() {

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCliente AC = new AgregarCliente();
                AC.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new Principal().panelPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }

