package org.blackpowerc.training.testcontainers;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Configuration conteneur singleton pour les tests de la couche data.
 */
@Testcontainers
public class TestContainerConfiguration
{
    @ServiceConnection
    protected static PostgreSQLContainer<?> pg = new PostgreSQLContainer<>("postgres:16.6-bullseye") ;

    static
    {
        pg.start() ;
        pg.setWaitStrategy(new HostPortWaitStrategy()) ;
    }
}
