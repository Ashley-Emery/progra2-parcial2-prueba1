/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2.parcial2.prueba1;

/**
 *
 * @author ashley
 */

import java.io.File;

public class Analizador {

    int txt = 0;
    int java = 0;
    int pdf = 0;
    int otros = 0;

    public void contarArchivos(File carpeta){

        File[] archivos = carpeta.listFiles();

        if (archivos == null) {
            return;
        }

        for (File archivo : archivos) {

            if (archivo.isDirectory()) {

                contarArchivos(archivo);

            } else {

                String nombre = archivo.getName().toLowerCase();

                if (nombre.endsWith(".txt")) {
                    txt++;
                } else if (nombre.endsWith(".java")) {
                    java++;
                } else if (nombre.endsWith(".pdf")) {
                    pdf++;
                } else {
                    otros++;
                }

            }
        }

    }

    public String buscarArchivos(File carpeta, String texto) {

        String resultados = "";

        File[] archivos = carpeta.listFiles();

        if (archivos == null) {
            return resultados;
        }

        for (File archivo : archivos) {

            if (archivo.isDirectory()) {

                resultados += buscarArchivos(archivo,texto);

            } else {

                String nombre = archivo.getName().toLowerCase();

                if (nombre.contains(texto.toLowerCase())) {

                    resultados +=archivo.getAbsolutePath()+ "\n";
                }
            }
        }

        return resultados;
    }
    
}
