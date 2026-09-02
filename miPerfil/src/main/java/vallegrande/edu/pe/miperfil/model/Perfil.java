package vallegrande.edu.pe.miperfil.model;

public class Perfil {
    private String nombre;
    private String carrera;
    private String semestre;
    private String hobby; // Dato adicional

    public Perfil(String nombre, String carrera, String semestre, String hobby){
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.hobby = hobby;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCarrera(){
        return carrera;
    }
    public String getSemestre(){
        return semestre;
    }
    public String getHobby(){
        return hobby;
    }
    public String obtenerPresentacion(){
        return "Hola, soy " + nombre + "\nCarrera: " + carrera + "\nSemestre: " + semestre + "\nHobby: " + hobby;
    }
}