package org.unicartagena.actividad.enfermedades.repository;

import org.unicartagena.actividad.enfermedades.enums.UsuarioEnum;
import org.unicartagena.actividad.enfermedades.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndPassword(String email, String password);
    List<Users> findByRole(UsuarioEnum role);
}
