package com.serverhub.server.service.implementation;

import com.serverhub.server.enumeration.Status;
import com.serverhub.server.model.Server;
import com.serverhub.server.repository.ServerRepository;
import com.serverhub.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Random;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService {

    private final ServerRepository serverRepository;
    @Override
    public Server createServer(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);

    }



    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server ip: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);

        if (!isLocalIpAddress(InetAddress.getByName(ipAddress))) {
            Socket socket = new Socket();
            int timeout = 5000;
            socket.connect(new InetSocketAddress(address, 80), timeout);
            boolean isConnected = socket.isConnected();
            socket.close();
            server.setStatus(isConnected? Status.SERVER_UP : Status.SERVER_DOWN);
            serverRepository.save(server);
        } else {
            server.setStatus(address.isReachable(5000) ? Status.SERVER_UP : Status.SERVER_DOWN);
            serverRepository.save(server);
        }

        return server;
    }

    private boolean isLocalIpAddress(InetAddress address) {
        // Check if the IP address falls within the private IP ranges
        byte[] ipBytes = address.getAddress();
        return (ipBytes[0] == 10)
                || (ipBytes[0] == (byte) 172 && (ipBytes[1] >= 16 && ipBytes[1] <= 31))
                || (ipBytes[0] == (byte) 192 && ipBytes[1] == (byte) 168);
    }

    @Override
    public Collection<Server> listServers(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0,limit)).toList();

    }

    @Override
    public Server getServer(Long id) {
        log.info("Fetching server b id: {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server updateServer(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server by id: {}", id);
        serverRepository.deleteById(id);
        return TRUE;
    }

    private String setServerImageUrl() {
        String[] imageNames = {"server1.png","server2.png","server3.png","server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"+imageNames[new Random().nextInt(4)]).toUriString();
    }
}
