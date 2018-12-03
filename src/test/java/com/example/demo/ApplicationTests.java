package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @LocalServerPort
    int port;

    @Test
    public void requestSucceeds() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:" + port);

        try (Response response = target.path("/").request().get()) {
            assertThat(response.getStatus()).isEqualTo(200);
        }
    }

}
