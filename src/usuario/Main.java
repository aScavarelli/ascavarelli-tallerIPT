package usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        SistemaUsuarios sistema = new SistemaUsuarios();

        int opcion=0;

        do {

            System.out.println("\n=== MENÚ ===");
            System.out.println("1 - Registro de Usuario");
            System.out.println("2 - Login");
            System.out.println("3 - Listar Usuarios");
            System.out.println("4 - Buscar Usuarios");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");

            if (teclado.hasNextInt()) {

                opcion = teclado.nextInt();
                teclado.nextLine();

            } else {

                System.out.println(" Opción inválida. Debe ingresar un número.");
                teclado.nextLine();
                continue;
            }

            switch (opcion) {

                case 1:

                    sistema.registrar(teclado);

                    break;

                case 2:

                    sistema.login(teclado);

                    break;

                case 3:
                    sistema.listarUsuarios();

                    break;

                case 4:
                    sistema.buscarUsuario(teclado);

                    break;

                    case 5:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        teclado.close();

    }

}
