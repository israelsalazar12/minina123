package Dao;

import Model.Persona;
import ejemplodao.EjemploDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author HP pro
 */
public class PersonaDaoIMP {

    public static void ConsultarTodo(String nombreArchivo) {
        InputStream inputStream = EjemploDao.class.getResourceAsStream(nombreArchivo);

        if (inputStream != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No se pudo encontrar el archivo: " + nombreArchivo);
        }
    }

    public static void BuscarPorId(String nombreArchivo, int idABuscar) {
        InputStream inputStream = EjemploDao.class.getResourceAsStream(nombreArchivo);

        if (inputStream != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String linea;
                boolean encontrado = false;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(" ");
                    if (partes.length == 3) {
                        int id = Integer.parseInt(partes[0].trim());
                        if (id == idABuscar) {
                            String nombre = partes[1];
                            int edad = Integer.parseInt(partes[2]);
                            System.out.println("ID encontrado: " + id);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Edad: " + edad);
                            encontrado = true;
                            break;
                        }
                    }
                }
                if (!encontrado) {
                    System.out.println("ID no encontrado: " + idABuscar);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No se pudo encontrar el archivo: " + nombreArchivo);
        }
    }

    public static void AgregarPersona(String nombreArchivo, Persona persona) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo, true))) {
            outputStream.writeObject(persona);
            System.out.println("Persona agregada al archivo: " + persona);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean BorrarTodo(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            // Esto crea un nuevo archivo vacío y sobrescribe el contenido existente
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    }

