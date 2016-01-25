package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 25/01/2016.
 */
@Path("fornitore")
public class Fornitore {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Fornitore[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Fornitore[] list = DAOFactory.getDAOFactory().getFornitoreDAO().listFornitoreByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Fornitore[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Fornitore getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Fornitore p = DAOFactory.getDAOFactory().getFornitoreDAO().getFornitoreByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getFornitore(com.coedil99.modello_di_dominio.Fornitore p)
    {
        try {

            DAOFactory.getDAOFactory().getFornitoreDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
