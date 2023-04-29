package edu.upc.paneando.dto;

public class ClienteLoginDTO {
    private Long idCliente;
    private String nombre;
    private String apellidos;
    private Boolean activo;

    public ClienteLoginDTO() {
    }

    public ClienteLoginDTO(Long idCliente, String nombre, String apellidos, Boolean activo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.activo = activo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
