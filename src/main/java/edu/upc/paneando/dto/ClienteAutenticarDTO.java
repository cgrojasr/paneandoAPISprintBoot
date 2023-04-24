package edu.upc.paneando.dto;

public class ClienteAutenticarDTO {
    public String email;
    public String password;

    public ClienteAutenticarDTO() {
    }

    public ClienteAutenticarDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
