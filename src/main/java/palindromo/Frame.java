
package palindromo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Palíndromos");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(400, 150);
            ventana.setLayout(new BorderLayout());

            JTextField campoEntrada = new JTextField();
            JButton botonVerificar = new JButton("Verificacion");
            JLabel etiquetaResultado = new JLabel("");

            botonVerificar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String entrada = campoEntrada.getText().toLowerCase().replaceAll("[^a-zA-Z]", "");
                    boolean esPalindromo = true;
                    int longitud = entrada.length();

                    for (int i = 0; i < longitud / 2; i++) {
                        if (entrada.charAt(i) != entrada.charAt(longitud - i - 1)) {
                            esPalindromo = false;
                            break;
                        }
                    }

                    if (esPalindromo) {
                        etiquetaResultado.setText(campoEntrada.getText() + "El dato si es un palindromo.");
                    } else {
                        etiquetaResultado.setText(campoEntrada.getText() + " El dato no es un palindromo");
                    }
                }
            });

            JPanel panelEntrada = new JPanel(new FlowLayout());
            panelEntrada.add(new JLabel("Indica el dato:"));
            panelEntrada.add(campoEntrada);

            JPanel panelBoton = new JPanel(new FlowLayout());
            panelBoton.add(botonVerificar);

            ventana.add(panelEntrada, BorderLayout.NORTH);
            ventana.add(panelBoton, BorderLayout.CENTER);
            ventana.add(etiquetaResultado, BorderLayout.SOUTH);

            ventana.setVisible(true);
        });
    }
}
