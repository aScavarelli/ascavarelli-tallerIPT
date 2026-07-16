package usuario;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SistemaUsuarios {

    //private Usuario[] usuarios;
    private List<Usuario> usuarios;
    public SistemaUsuarios() {

        //usuarios = new Usuario[10];
        usuarios = new ArrayList<>();

        usuarios.add(new Admin(
                "Ana",
                "Lopez",
                "tester@test.com",
                "Uruguay",
                "1234"
        ));

        usuarios.add(new Tester(
                "Ana",
                "Lopez",
                "tester@test.com",
                "Uruguay",
                "1234"));
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

            usuarios.add(new Admin(
                    nombre,
                    apellido,
                    email,
                    pais,
                    contrasena));

        } else if (tipo == 2) {

            usuarios.add(new Tester(
                    nombre,
                    apellido,
                    email,
                    pais,
                    contrasena));

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

            System.out.println("Perfil: " + usuario.obtenerPerfil());

        } else {

            System.out.println("Contraseña incorrecta.");

        }
    }

    public Usuario buscarUsuario(String email) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equalsIgnoreCase(email)) {

                return usuario;

            }

        }

        return null;
    }

    public void listarUsuarios() {

        if (usuarios.isEmpty()) {

            System.out.println("No hay usuarios registrados.");
            return;

        }

        for (Usuario usuario : usuarios) {

            System.out.println("----------------------");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Perfil: " + usuario.obtenerPerfil());

        }

    }

    public void buscarUsuario(Scanner teclado) {

        System.out.print("Ingrese el email: ");
        String email = teclado.nextLine();

        Usuario usuario = buscarUsuario(email);

        if (usuario == null) {

            System.out.println("Usuario no encontrado.");

        } else {

            System.out.println("\n=== USUARIO ENCONTRADO ===");
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Apellido: " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("País: " + usuario.getPais());
            System.out.println("Perfil: " + usuario.obtenerPerfil());

        }
    }

}