package com.soap.SoapServer.services;

import com.soap.SoapServer.entities.Tienda;
import com.soap.SoapServer.entities.User;
import com.soap.SoapServer.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para encontrar un usuario por su nombre de usuario
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Método para encontrar todos los usuarios de una tienda
    public List<User> findByTienda(Tienda tienda) {
        return userRepository.findByTienda(tienda);
    }

    // Método para guardar un nuevo usuario
    public User save(User user) {
        return userRepository.save(user);
    }

    // Método para actualizar un usuario existente
    public User update(User user) {
        return userRepository.save(user);
    }

    // Método para eliminar un usuario por su ID
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    // Método para obtener todos los usuarios
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) { return userRepository.findById(id);}
}