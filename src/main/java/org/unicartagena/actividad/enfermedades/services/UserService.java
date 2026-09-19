package org.unicartagena.actividad.enfermedades.services;

import org.unicartagena.actividad.enfermedades.models.Users;
import org.unicartagena.actividad.enfermedades.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepository UserRepo;

    public List<Users> listUser() { return UserRepo.findAll(); }
    public void saveUser(Users u) { UserRepo.save(u); }
    public Users searchUser(Long id) { return UserRepo.findById(id).orElse(null); }
    public void deleteUser(Long id) { UserRepo.deleteById(id); }

    public Users autenticate(String email, String password) {
        return UserRepo.findByEmailAndPassword(email, password).orElse(null);
    }
    public Users searchByEmail(String email) {
        return UserRepo.findByEmail(email).orElse(null);
    }
}
