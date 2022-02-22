///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.postgresql:postgresql:42.2.14
//DEPS org.testcontainers:postgresql:1.15.2
//DEPS org.postgresql:postgresql:42.2.14
//DEPS org.slf4j:slf4j-simple:1.7.25

import java.util.function.Consumer;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class startdb {

    public static void main(String... args) {
        GenericContainer gc = startdb();
        try {
            gc.start();
        } finally {
            System.out.println("Press enter to stop database");
            System.console().readLine();
            gc.stop();
        }
    }

    private static GenericContainer startdb() {
        int hostPort = 5432;
        int containerExposedPort = 5432;

        Consumer<CreateContainerCmd> cmd = e -> e.withPortBindings(
                new PortBinding((Ports.Binding.bindPort(hostPort)), new ExposedPort(containerExposedPort)));

        DockerImageName myImage = DockerImageName.parse("frantiseks/postgres-sakila")
                .asCompatibleSubstituteFor("postgres");

        var dbcontainer = new PostgreSQLContainer(myImage).withDatabaseName("sakila").withUsername("postgres")
                .withPassword("sakila").withCreateContainerCmdModifier(cmd);
        return dbcontainer;
    }
}