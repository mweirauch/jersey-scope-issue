package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Service
    @Scope(scopeName = "request")
    static class HelloService {

        public String greet() {
            return "Hi from " + this + "!";
        }

    }

    @Component
    static class JerseyResourceConfig extends ResourceConfig {

        public JerseyResourceConfig() {
            register(RootResource.class);
        }

    }

    @Path("/")
    public static class RootResource {

        @Autowired
        HelloService helloService;

        @GET
        public String index() {
            return helloService.greet();
        }

    }

}
