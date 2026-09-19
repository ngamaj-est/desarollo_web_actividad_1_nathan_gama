package org.unicartagena.actividad.enfermedades.repository;

import org.unicartagena.actividad.enfermedades.enums.NivelGravedadEnum;
import org.unicartagena.actividad.enfermedades.models.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnfermedadesRepository extends JpaRepository <Enfermedad, Long> {
    List<Enfermedad> findByNivelGravedad(NivelGravedadEnum nivelGravedad);
    List<Enfermedad> findByEsContagiosaTrueAndRequiereIncapacidadTrue();
}