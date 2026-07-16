package usuario;

public class Tester extends Usuario {

    public Tester(String nombre, String apellido,
                  String email, String pais, String contrasena) {

        super(nombre, apellido, email, pais, contrasena);
    }

    @Override
    public String obtenerPerfil() {
        return "Tester";
    }
}
