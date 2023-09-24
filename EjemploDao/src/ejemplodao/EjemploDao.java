package ejemplodao;

import static Dao.PersonaDaoIMP.AgregarPersona;
import static Dao.PersonaDaoIMP.BorrarTodo;
import static Dao.PersonaDaoIMP.BuscarPorId;
import static Dao.PersonaDaoIMP.ConsultarTodo;
import Model.Persona;
import java.util.Scanner;

/**
 *
 * @author HP pro
 */
public class EjemploDao {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int x;

        System.out.println("1.Consultar todo");
        System.out.println("2.Buscar por id");
        System.out.println("3.Agregar persona");
        System.out.println("4.BOrrar todo");
        System.out.println("5.Borrar id");
        System.out.println("6.Actualizar");
        System.out.println("Escoja una opcion");
        x = leer.nextInt();

        switch (x) {
            case 1:
                ConsultarTodo("datos.txt");
                break;

            case 2:
                BuscarPorId("datos.txt", 3);
                break;

            case 3:
                Persona nuevaPersona = new Persona(4, "Juanetee", 15);
                AgregarPersona("datos.txt", nuevaPersona);
                break;

            case 4:
                String nombreArchivo = "datos.txt";
                boolean borradoExitoso = BorrarTodo(nombreArchivo);
                if (borradoExitoso) {
                    System.out.println("Se ha borrado todo el contenido del archivo: " + nombreArchivo);
                }

                break;

            case 5:

                break;

            case 6:

                break;
        }

    }
}
