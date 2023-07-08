package com.serverhub.server.service;
import com.serverhub.server.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {

    Server createServer(Server server);

    Server ping (String ipAddress) throws IOException;
    Collection<Server> listServers(int limit);
    Server getServer(Long id);
    Server updateServer(Server server);
    Boolean delete(Long id);


}
