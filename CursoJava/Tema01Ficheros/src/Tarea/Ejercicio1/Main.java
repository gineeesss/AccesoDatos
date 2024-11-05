package Tarea.Ejercicio1;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path configPath = Paths.get("ventas", "config.dat");
        String rutaLog = null;
        System.out.println("Directorio de trabajo: " + Paths.get("").toAbsolutePath());

        // Leer el archivo de configuración en formato binario
        try (DataInputStream dis = new DataInputStream(new FileInputStream(configPath.toFile()))) {
            // Leer los campos del archivo de configuración
            int puerto = dis.readInt(); // Leer el puerto como un entero
            String nomapp = dis.readUTF(); // Leer el nombre de la aplicación como cadena
            rutaLog = dis.readUTF(); // Leer la ruta del log como cadena
            int numses = dis.readInt(); // Leer el número de sesiones como entero
            
            // Mostrar los valores leídos
            System.out.println("Puerto: " + puerto);
            System.out.println("Nombre de la aplicación: " + nomapp);
            System.out.println("Ruta del log: " + rutaLog);
            System.out.println("Número de sesiones: " + numses);
            
        } catch (IOException e) {
            // Registrar error en incidencias.log
            escribirError("Error leyendo el archivo de configuración: " + e.getMessage());
            return; // Terminar si hay error
        }

        // Comprobar si la ruta del log es válida
        if (rutaLog == null) {
            escribirError("No se pudo encontrar la ruta del fichero de log en config.dat.");
            return;
        }

        // Comprobar si el archivo de log existe
        Path rutaLogPath = Paths.get(rutaLog);
        if (!Files.exists(rutaLogPath)) {
            escribirError("El archivo de log no existe en la ruta especificada: " + rutaLogPath.toAbsolutePath());
            return; // Terminar si no se encuentra el archivo de log
        }

        // Leer el archivo de log y escribir incidencias en incidencias.log
        try (BufferedReader br = new BufferedReader(new FileReader(rutaLog));
             BufferedWriter bw = new BufferedWriter(new FileWriter("incidencias.log", true))) { // Modo append

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("Error")) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
            System.out.println("Procesamiento completado. Revisar incidencias.log para detalles.");
        } catch (IOException e) {
            // Registrar error en incidencias.log
            escribirError("Error procesando el archivo de log: " + e.getMessage());
        }
    }

    // Método para escribir errores en incidencias.log
    private static void escribirError(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("incidencias.log", true))) {
            bw.write(mensaje);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en incidencias.log: " + e.getMessage());
        }
    }
}
