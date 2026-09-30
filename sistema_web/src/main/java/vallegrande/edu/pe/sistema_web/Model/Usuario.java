package vallegrande.edu.pe.sistema_web.Model;

public class Usuario {
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String producto;
    private String tipoComprador;
    private String mensaje;

    public Usuario(Integer id, String nombre, String email, String telefono, String producto, String tipoComprador, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.producto = producto;
        this.tipoComprador = tipoComprador;
        this.mensaje = mensaje;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getProducto() { return producto; }
    public String getTipoComprador() { return tipoComprador; }
    public String getMensaje() { return mensaje; }
}