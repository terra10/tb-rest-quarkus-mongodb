package org.acme.mongodb;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.acme.mongodb.model.Beer;
import org.acme.mongodb.repository.BeerRepository;

@Path("/beers/1.0")
@Consumes("application/json")
@Produces("application/json")
public class BeerController {

    private final BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GET()
    public List<Beer> getAllBeers() {
        return beerRepository.listAll();
    }

    @GET
    @Path("/{beerName}")
    public Beer getBeerByName(@PathParam("beerName") String name) {
        return beerRepository.findByName(name);
    }

    @POST
    public Response saveOrUpdateBeer(Beer beer) {
        beerRepository.persistOrUpdate(beer);
        return Response.ok("Beer added successfully").build();
    }

    @DELETE
    @Path(value = "/{beerName}")
    public Response deleteBeer(@PathParam("beerName") String name) {

        beerRepository.delete(beerRepository.findByName(name));
        return Response.noContent().build();
    }

}