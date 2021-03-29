package org.acme.mongodb;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.mongodb.model.Beer;
import org.acme.mongodb.repository.BeerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BeerControllerTest {

    @InjectMock
    BeerRepository beerRepository;

    @Test
    public void testFindBeerByName() {
        Beer beer = new Beer();
        beer.setName("panache");
        Mockito.when(beerRepository.findByName("banana")).thenReturn(beer);

        given()
          .when().get("beers/1.0/banana")
          .then()
             .statusCode(200)
             .body(is("{\"name\":\"panache\"}"));
    }

}