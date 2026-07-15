package usuario;

import java.util.Scanner;

public class SistemaUsuarios {

    private Usuario[] usuarios;
    private int cantidad;

    public SistemaUsuarios() {

        usuarios = new Usuario[10];
        cantidad = 0;

        usuarios[cantidad++] = new Admin(
                "Juan",
                "Perez",
                "admin@test.com",
                "Uruguay",
                "1234");

        usuarios[cantidad++] = new Tester(
                "Ana",
                "Lopez",
                "tester@test.com",
                "Uruguay",
                "1234");
    }

    public void registrar(Scanner teclado) {

        System.out.println("\n=== REGISTRO ===");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Email: ");
        String email = teclado.nextLine();

        if (buscarUsuario(email) != null) {
            System.out.println("El usuario ya existe.");
            return;
        }

        System.out.print("Pais: ");
        String pais = teclado.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = teclado.nextLine();

        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Tester");
        System.out.print("Opción: ");

        int tipo = teclado.nextInt();
        teclado.nextLine();

        if (tipo == 1) {

            usuarios[cantidad++] = new Admin(
                    nombre,
                    apellido,
                    email,
                    pais,
                    contrasena);

        } else if (tipo == 2) {

            usuarios[cantidad++] = new Tester(
                    nombre,
                    apellido,
                    email,
                    pais,
                    contrasena);

        } else {

            System.out.println("Tipo de usuario inválido.");
            return;
        }

        System.out.println("Usuario registrado correctamente.");
    }

    public void login(Scanner teclado) {

        System.out.print("Email: ");
        String email = teclado.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = teclado.nextLine();

        Usuario usuario = buscarUsuario(email);

        if (usuario == null) {

            System.out.println("Usuario no encontrado.");
            return;

        }

        if (usuario.getContrasena().equals(contrasena)) {

            System.out.println("Login exitoso.");
            System.out.println("Bienvenido " + usuario.getNombre() + " " + usuario.getApellido());

            if (usuario instanceof Admin) {
                System.out.println("Perfil: Administrador");
            } else {
                System.out.println("Perfil: Tester");
            }

        } else {

            System.out.println("Contraseña incorrecta.");

        }
    }

    public Usuario buscarUsuario(String email) {

        for (int i = 0; i < cantidad; i++) {

            if (usuarios[i].getEmail().equals(email)) {

                return usuarios[i];

            }

        }

        return null;
    }

}