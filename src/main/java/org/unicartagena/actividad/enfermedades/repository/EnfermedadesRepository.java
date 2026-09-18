package org.unicartagena.actividad.enfermedades.repository;

import org.unicartagena.actividad.enfermedades.enums.NivelGravedadEnum;
import org.unicartagena.actividad.enfermedades.models.Enfermedades;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnfermedadesRepository extends JpaRepository <Enfermedades, Long> {
    List<Enfermedades> findByNivelGravedad(NivelGravedadEnum nivelGravedad);
    List<Enfermedades> findByEsContagiosaTrueAndRequiereIncapacidadTrue();
}