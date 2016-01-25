package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 24/01/2016.
 */
@Path("rda")
public class RDA {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.RDA[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.RDA[] list = DAOFactory.getDAOFactory().getRDADAO().listRDAByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.RDA[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.RDA getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.RDA p = DAOFactory.getDAOFactory().getRDADAO().getRDAByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRDA(com.coedil99.modello_di_dominio.RDA p)
    {
        try {

            DAOFactory.getDAOFactory().getRDADAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
