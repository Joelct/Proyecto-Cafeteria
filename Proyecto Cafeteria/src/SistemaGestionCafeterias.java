import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Clase principal del sistema de gestión de cafeterías
public class SistemaGestionCafeterias {
    public static void main(String[] args) {
        // Crear una instancia de GestorUsuarios y agregar algunos usuarios de prueba
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        gestorUsuarios.agregarUsuario("usuario1", "contraseña1", "admin");
        gestorUsuarios.agregarUsuario("usuario2", "contraseña2", "empleado");

        // Solicitar al usuario que inicie sesión
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();

        // Verificar las credenciales del usuario
        if (gestorUsuarios.verificarCredenciales(nombreUsuario, contraseña)) {
            System.out.println("Inicio de sesión exitoso.");
            // Lógica adicional después del inicio de sesión exitoso
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }
}

// Clase para gestionar usuarios y sus credenciales
class GestorUsuarios {
    private Map<String, String> usuarios; // Mapa para almacenar nombres de usuario y contraseñas
    private Map<String, String> permisos; // Mapa para almacenar nombres de usuario y sus roles

    // Constructor para inicializar los mapas
    public GestorUsuarios() {
        usuarios = new HashMap<>();
        permisos = new HashMap<>();
    }

    // Método para agregar un usuario con su contraseña y permisos
    public void agregarUsuario(String nombreUsuario, String contraseña, String rol) {
        usuarios.put(nombreUsuario, contraseña);
        permisos.put(nombreUsuario, rol);
    }

    // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String nombreUsuario, String contraseña) {
        // Verificar si el nombre de usuario existe en el mapa
        if (usuarios.containsKey(nombreUsuario)) {
            // Verificar si la contraseña coincide
            return usuarios.get(nombreUsuario).equals(contraseña);
        }
        return false; // El nombre de usuario no existe
    }
}
