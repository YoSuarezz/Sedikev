package com.sedikev.infrastructure.adapter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lote")
public class LoteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private UsuarioEntity usuario;

    @Column(name = "contramarca")
    private int contramarca;

    @Column(name = "precio_kilo")
    private BigDecimal precio_kilo;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AnimalEntity> lista_animalEntity;

    @OneToMany(mappedBy = "lote", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GastoEntity> lista_gastoEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public int getContramarca() {
        return contramarca;
    }

    public void setContramarca(int contramarca) {
        this.contramarca = contramarca;
    }

    public BigDecimal getPrecio_kilo() {
        return precio_kilo;
    }

    public void setPrecio_kilo(BigDecimal precio_kilo) {
        this.precio_kilo = precio_kilo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<AnimalEntity> getLista_animalEntity() {
        return lista_animalEntity;
    }

    public void setLista_animalEntity(List<AnimalEntity> lista_animalEntity) {
        this.lista_animalEntity = lista_animalEntity;
    }

    public List<GastoEntity> getLista_gastoEntity() {
        return lista_gastoEntity;
    }

    public void setLista_gastoEntity(List<GastoEntity> lista_gastoEntity) {
        this.lista_gastoEntity = lista_gastoEntity;
    }
}
