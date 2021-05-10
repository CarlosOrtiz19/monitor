package com.monitorchanges.monitor.repository;


import com.monitorchanges.monitor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
