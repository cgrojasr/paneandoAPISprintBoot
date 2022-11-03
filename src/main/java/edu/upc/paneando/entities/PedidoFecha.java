package edu.upc.paneando.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pedido_fecha")
public class PedidoFecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_fecha")
    private Long idPedidoFecha;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    @JsonIgnore
    private Pedido objPedido;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "hora_minuto")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private Timestamp horaMinuto;

    @Column(name = "activo")
    private Boolean activo;

    public PedidoFecha() {
    }

    public PedidoFecha(Long idPedidoFecha, Pedido objPedido, String diaSemana, Timestamp horaMinuto, Boolean activo) {
        this.idPedidoFecha = idPedidoFecha;
        this.objPedido = objPedido;
        this.diaSemana = diaSemana;
        this.horaMinuto = horaMinuto;
        this.activo = activo;
    }

    public Long getIdPedidoFecha() {
        return idPedidoFecha;
    }

    public void setIdPedidoFecha(Long idPedidoFecha) {
        this.idPedidoFecha = idPedidoFecha;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Timestamp getHoraMinuto() {
        return horaMinuto;
    }

    public void setHoraMinuto(Timestamp horaMinuto) {
        this.horaMinuto = horaMinuto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Pedido getObjPedido() {
        return objPedido;
    }

    public void setObjPedido(Pedido objPedido) {
        this.objPedido = objPedido;
    }
}
