package org.unicartagena.actividad.enfermedades.services;

import org.unicartagena.actividad.enfermedades.models.Enfermedades;
import org.unicartagena.actividad.enfermedades.repository.EnfermedadesRepository;
import org.unicartagena.actividad.enfermedades.enums.NivelGravedadEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnfermedadesServices {
    @Autowired private EnfermedadesRepository EnfermedadesRepo;

    public List<Enfermedades> listEnfermedades() { return EnfermedadesRepo.findAll(); }
    public void saveEnfermedades(Enfermedades e) { EnfermedadesRepo.save(e); }
    public Enfermedades searchEnfermedades(Long id) { return EnfermedadesRepo.findById(id).orElse(null); }
    public void deleteEnfermedades(Long id) { EnfermedadesRepo.deleteById(id); }

    public List<Enfermedades> reporteGravedad(NivelGravedadEnum nivel) {
        return EnfermedadesRepo.findByNivelGravedad(nivel);
    }
    public List<Enfermedades> reporteCritico() {
        return EnfermedadesRepo.findByEsContagiosaTrueAndRequiereIncapacidadTrue();
    }
}