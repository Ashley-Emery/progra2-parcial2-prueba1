/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.parcial2.prueba1;

/**
 *
 * @author ashley
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AnalizadorGUI extends JFrame {

    JTextField txtRuta, txtBuscar;
    JTextArea area;

    public AnalizadorGUI() {

        setTitle("Analizador");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtRuta = new JTextField();
        txtBuscar = new JTextField();

        area = new JTextArea();
        area.setEditable(false);

        JButton btnAnalizar = new JButton("Analizar");

        JPanel panel = new JPanel(new GridLayout(5,1));

        panel.add(new JLabel("Ruta del directorio"));
        panel.add(txtRuta);
        panel.add(new JLabel("Texto a buscar"));
        panel.add(txtBuscar);
        panel.add(btnAnalizar);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        btnAnalizar.addActionListener(e -> analizar());

        setVisible(true);
    }

    public void analizar() {

        area.setText("");

        File carpeta = new File(txtRuta.getText());

        if (!carpeta.exists() || !carpeta.isDirectory()) {
            area.setText("Ruta invalida.");
            return;
        }

        Analizador analizador = new Analizador();

        analizador.contarArchivos(carpeta);

        area.append("TXT: " + analizador.txt + "\n");
        area.append("JAVA: " + analizador.java + "\n");
        area.append("PDF: " + analizador.pdf + "\n");
        area.append("OTROS: " + analizador.otros + "\n\n");

        area.append("Busqueda:\n");

        String resultados = analizador.buscarArchivos(
                carpeta,
                txtBuscar.getText()
        );

        if (resultados.isEmpty()) {
            area.append("No se encontraron archivos.");
        } else {
            area.append(resultados);
        }
    }
    
}
