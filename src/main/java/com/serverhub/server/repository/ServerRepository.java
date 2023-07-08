package com.serverhub.server.repository;

import com.serverhub.server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server,Long> {

    Server findByIpAddress(String ipAddress);




}
