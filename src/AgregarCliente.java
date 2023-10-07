import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.DatabaseConnection;

public class AgregarCliente {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton agregarButton;
    private JButton cancelarButton;

    private DatabaseConnection dbConnection;

    public AgregarCliente() {
        dbConnection = new DatabaseConnection();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a,b,c,d;

                a = textField1.getText();
                b = textField2.getText();
                c = textField3.getText();
                d = textField4.getText();
            }
        });
    }
}
