package usuario;

public class Tester extends Usuario {

    private String nivel;

    public Tester(String nombre, String apellido,
                  String email, String pais,
                  String contrasena, String nivel) {

        super(nombre, apellido, email, pais, contrasena);
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String obtenerPerfil() {
        return "Tester - " + nivel;
    }
}
