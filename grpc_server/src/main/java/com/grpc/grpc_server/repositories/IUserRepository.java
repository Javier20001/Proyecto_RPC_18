package com.grpc.grpc_server.repositories;

import com.grpc.grpc_server.entities.Tienda;
import com.grpc.grpc_server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Integer> {

    public abstract Optional<User> findByUsername(String username);

    public abstract List<User> findByTienda(Tienda tienda);

}
