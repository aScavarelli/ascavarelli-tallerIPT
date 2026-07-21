package usuario;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import usuario.excepciones.UsuarioNoEncontradoException;
import usuario.excepciones.EmailDuplicadoException;

public class SistemaUsuarios {

    private List<Usuario> usuarios;
    private Usuario usuarioLogueado;

    private static SistemaUsuarios instancia;


    private SistemaUsuarios() {

        usuarios = new ArrayList<>();

        usuarios.add(new Admin(
                "Ana",
                "Lopez",
                "admin@test.com",
                "Uruguay",
                "1234"
        ));


        usuarios.add(new Tester(
                "Ana",
                "Lopez",
                "tester@test.com",
                "Uruguay",
                "1234",
                "Senior"
        ));

    }


    public static SistemaUsuarios getInstance() {

        if (instancia == null) {

            instancia = new SistemaUsuarios();

        }

        return instancia;
    }

    private void registrar(Scanner teclado, int tipo) throws EmailDuplicadoException {

        System.out.println("\n=== REGISTRO ===");

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        if(nombre.isEmpty()) {

            System.out.println("El nombre es obligatorio.");
            return;

        }


        System.out.print("Apellido: ");
        String apellido = teclado.nextLine();

        if(apellido.isEmpty()) {

            System.out.println("El apellido es obligatorio.");
            return;

        }


        System.out.print("Email: ");
        String email = teclado.nextLine();


        if(email.isEmpty()) {

            System.out.println("El email es obligatorio.");
            return;

        }

        if(!email.contains("@") || !email.contains(".")) {

            System.out.println("Email inválido.");
            return;

        }


        try {
            buscarUsuario(email);
            throw new EmailDuplicadoException(
                    "El email ya existe."
            );


        } catch (UsuarioNoEncontradoException e) {

        }



        System.out.print("Pais: ");
        String pais = teclado.nextLine();


        if(pais.isEmpty()) {

            System.out.println("El país es obligatorio.");
            return;

        }

        System.out.print("Contraseña: ");
        String contrasena = teclado.nextLine();


        if(contrasena.length() < 4) {

            System.out.println(
                    "La contraseña debe tener mínimo 4 caracteres."
            );

            return;

        }

        if(tipo == 1) {


            usuarios.add(new Admin(
                    nombre,
                    apellido,
                    email,
                    pais,
                    contrasena
            ));


        } else if(tipo == 2) {


            System.out.print(
                    "Nivel (Junior/Semi Senior/Senior): "
            );

            String nivel = teclado.nextLine();



            usuarios.add(new Tester(
                    nombre,
                    apellido,
                    email,
                    pais,
                    contrasena,
                    nivel
            ));


        }



        System.out.println(
                "Usuario registrado correctamente."
        );

    }




    public void registrarAdministrador(Scanner teclado)
            throws EmailDuplicadoException {


        registrar(teclado,1);

    }



    public void registrarTester(Scanner teclado)
            throws EmailDuplicadoException {


        registrar(teclado,2);

    }





    public void login(Scanner teclado) {


        System.out.print("Email: ");
        String email = teclado.nextLine();


        System.out.print("Contraseña: ");
        String contrasena = teclado.nextLine();



        try {


            Usuario usuario = buscarUsuario(email);



            if(usuario.getContrasena()
                    .equals(contrasena)) {


                usuarioLogueado = usuario;


                System.out.println(
                        "Login exitoso."
                );


                System.out.println(
                        "Bienvenido "
                                + usuario.getNombre()
                                + " "
                                + usuario.getApellido()
                );


                System.out.println(
                        "Perfil: "
                                + usuario.obtenerPerfil()
                );


            } else {


                System.out.println(
                        "Contraseña incorrecta."
                );


            }



        } catch (UsuarioNoEncontradoException e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }






    public Usuario buscarUsuario(String email)
            throws UsuarioNoEncontradoException {

        for(Usuario usuario : usuarios) {


            if(usuario.getEmail()
                    .equalsIgnoreCase(email)) {


                return usuario;

            }

        }


        throw new UsuarioNoEncontradoException(
                "Usuario no encontrado."
        );


    }

    public void listarUsuarios() {



        if(usuarios.isEmpty()) {


            System.out.println(
                    "No hay usuarios registrados."
            );

            return;

        }




        for(Usuario usuario : usuarios) {


            System.out.println("-------------------");

            System.out.println(
                    "Nombre: "
                            + usuario.getNombre()
            );


            System.out.println(
                    "Apellido: "
                            + usuario.getApellido()
            );


            System.out.println(
                    "Email: "
                            + usuario.getEmail()
            );


            System.out.println(
                    "Perfil: "
                            + usuario.obtenerPerfil()
            );


        }


    }

    public void buscarUsuarioPorConsola(Scanner teclado) {


        System.out.print(
                "Ingrese email: "
        );


        String email = teclado.nextLine();



        try {


            Usuario usuario = buscarUsuario(email);



            System.out.println(
                    "\n=== USUARIO ENCONTRADO ==="
            );


            System.out.println(
                    "Nombre: "
                            + usuario.getNombre()
            );


            System.out.println(
                    "Apellido: "
                            + usuario.getApellido()
            );


            System.out.println(
                    "Email: "
                            + usuario.getEmail()
            );


            System.out.println(
                    "País: "
                            + usuario.getPais()
            );


            System.out.println(
                    "Perfil: "
                            + usuario.obtenerPerfil()
            );



        } catch (UsuarioNoEncontradoException e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }





    public void cerrarSesion() {


        usuarioLogueado = null;


        System.out.println(
                "Sesión cerrada."
        );


    }




    public boolean haySesion() {


        return usuarioLogueado != null;


    }


}