package org.unicartagena.actividad.enfermedades.models;

import org.unicartagena.actividad.enfermedades.enums.NivelGravedadEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "Enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false, unique = true)
    private String nombre;

    @Column(name = "nombreCientifico", length = 100, nullable = false)
    private String nombreCientifico;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivelGravedad", length = 20, nullable = false)
    private NivelGravedadEnum nivelGravedad;

    @Column(name = "sintomas", length = 500, nullable = false)
    private String sintomas;

    @Column(name = "medicamentos", length = 200, nullable = false)
    private String medicamentos;

    @Column(name = "esContagiosa", nullable = false)
    private boolean esContagiosa;

    @Column(name = "esCubiertaPorPos", nullable = false)
    private boolean esCubiertaPorPos;

    @Column(name = "requiereIncapacidad", nullable = false)
    private boolean requiereIncapacidad;

    public Enfermedad() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public NivelGravedadEnum getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(NivelGravedadEnum nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public boolean isEsContagiosa() {
        return esContagiosa;
    }

    public void setEsContagiosa(boolean esContagiosa) {
        this.esContagiosa = esContagiosa;
    }

    public boolean isEsCubiertaPorPos() {
        return esCubiertaPorPos;
    }

    public void setEsCubiertaPorPos(boolean esCubiertaPorPos) {
        this.esCubiertaPorPos = esCubiertaPorPos;
    }

    public boolean isRequiereIncapacidad() {
        return requiereIncapacidad;
    }

    public void setRequiereIncapacidad(boolean requiereIncapacidad) {
        this.requiereIncapacidad = requiereIncapacidad;
    }
}