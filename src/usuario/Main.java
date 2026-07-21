package usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        SistemaUsuarios sistema = SistemaUsuarios.getInstance();

        int opcion = 0;

        do {

            try {

                if (!sistema.haySesion()) {

                    System.out.println("\n=== MENÚ ===");
                    System.out.println("1 - Registrar Administrador");
                    System.out.println("2 - Iniciar Sesión");
                    System.out.println("3 - Salir");
                    System.out.print("Seleccione una opción: ");

                    if (teclado.hasNextInt()) {

                        opcion = teclado.nextInt();
                        teclado.nextLine();

                    } else {

                        System.out.println("Debe ingresar un número.");
                        teclado.nextLine();
                        continue;

                    }

                    switch (opcion) {

                        case 1:
                            sistema.registrarAdministrador(teclado);
                            break;

                        case 2:
                            sistema.login(teclado);
                            break;

                        case 3:
                            System.out.println("Programa finalizado.");
                            break;

                        default:
                            System.out.println("Opción inválida.");

                    }

                } else {

                    System.out.println("\n=== MENÚ ADMINISTRADOR ===");
                    System.out.println("1 - Registrar Tester");
                    System.out.println("2 - Listar Usuarios");
                    System.out.println("3 - Buscar Usuario");
                    System.out.println("4 - Cerrar Sesión");
                    System.out.println("5 - Salir");
                    System.out.print("Seleccione una opción: ");

                    if (teclado.hasNextInt()) {

                        opcion = teclado.nextInt();
                        teclado.nextLine();

                    } else {

                        System.out.println("Debe ingresar un número.");
                        teclado.nextLine();
                        continue;

                    }

                    switch (opcion) {

                        case 1:
                            sistema.registrarTester(teclado);
                            break;

                        case 2:
                            sistema.listarUsuarios();
                            break;

                        case 3:
                            sistema.buscarUsuarioPorConsola(teclado);
                            break;

                        case 4:
                            sistema.cerrarSesion();
                            break;

                        case 5:
                            System.out.println("Programa finalizado.");
                            break;

                        default:
                            System.out.println("Opción inválida.");

                    }

                }

            } catch (Exception e) {

                System.out.println("Ocurrió un error: " + e.getMessage());

            }

        } while (opcion != 3 && opcion != 5);

        teclado.close();
    }
}