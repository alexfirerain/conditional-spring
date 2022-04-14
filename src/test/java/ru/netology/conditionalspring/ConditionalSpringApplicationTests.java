package ru.netology.conditionalspring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalSpringApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;
    private static final GenericContainer<?> devapp = new GenericContainer<>("devapp").withExposedPorts(8080);
    private static final GenericContainer<?> prodapp = new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {

    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080), String.class);
        System.out.println(forEntity.getBody());
    }

}
