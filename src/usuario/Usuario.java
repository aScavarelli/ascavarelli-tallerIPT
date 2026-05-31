package usuario;

import java.util.Scanner;

public class Usuario {

    static String nombre;
    static String apellido;
    static String email;
    static String pais;
    static String contrasena;
    static String perfil;

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1 - Registro Administrador");
            System.out.println("2 - Login");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrar(teclado);
                    break;

                case 2:
                    login(teclado);
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        teclado.close();
    }

    public static void registrar(Scanner teclado) {

        System.out.println("\n=== REGISTRO ===");

        System.out.print("Nombre: ");
        nombre = teclado.nextLine();

        System.out.print("Apellido: ");
        apellido = teclado.nextLine();

        System.out.print("Email: ");
        email = teclado.nextLine();

        System.out.print("Pais: ");
        pais = teclado.nextLine();

        System.out.print("Contraseña: ");
        contrasena = teclado.nextLine();

        perfil = "Administrador";

        System.out.println("Usuario registrado correctamente.");
    }

    public static void login(Scanner teclado) {

        System.out.print("Email: ");
        String emailIngresado = teclado.nextLine();

        System.out.print("Contraseña: ");
        String contrasenaIngresada = teclado.nextLine();

        if (emailIngresado.equals(email) && contrasenaIngresada.equals(contrasena)) {
            System.out.println("Login exitoso.");
            System.out.println("Bienvenido " + nombre + " " + apellido);
            System.out.println("Perfil: " + perfil);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}
