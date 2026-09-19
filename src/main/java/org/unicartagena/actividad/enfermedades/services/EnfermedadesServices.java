package org.unicartagena.actividad.enfermedades.services;

import org.unicartagena.actividad.enfermedades.models.Enfermedad;
import org.unicartagena.actividad.enfermedades.repository.EnfermedadesRepository;
import org.unicartagena.actividad.enfermedades.enums.NivelGravedadEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnfermedadesServices {
    @Autowired private EnfermedadesRepository EnfermedadRepo;

    public List<Enfermedad> listEnfermedades() { return EnfermedadRepo.findAll(); }
    public void saveEnfermedades(Enfermedad e) { EnfermedadRepo.save(e); }
    public Enfermedad searchEnfermedades(Long id) { return EnfermedadRepo.findById(id).orElse(null); }
    public void deleteEnfermedades(Long id) { EnfermedadRepo.deleteById(id); }

    public List<Enfermedad> reporteGravedad(NivelGravedadEnum nivel) {
        return EnfermedadRepo.findByNivelGravedad(nivel);
    }
    public List<Enfermedad> reporteCritico() {
        return EnfermedadRepo.findByEsContagiosaTrueAndRequiereIncapacidadTrue();
    }
}