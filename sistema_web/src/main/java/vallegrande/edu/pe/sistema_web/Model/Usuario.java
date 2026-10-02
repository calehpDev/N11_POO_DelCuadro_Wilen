package vallegrande.edu.pe.sistema_web.Model;

public class Usuario {

    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String producto;
    private String tipoComprador;
    private String mensaje;

    // Constructor vacío (necesario para instanciar el objeto antes de asignarle datos)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(Integer id, String nombre, String email, String telefono, String producto, String tipoComprador, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.producto = producto;
        this.tipoComprador = tipoComprador;
        this.mensaje = mensaje;
    }

    // --- Getters y Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTipoComprador() {
        return tipoComprador;
    }

    public void setTipoComprador(String tipoComprador) {
        this.tipoComprador = tipoComprador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}