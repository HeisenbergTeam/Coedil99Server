package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 24/01/2016.
 */
@Path("commessa")
public class Commessa {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Commessa[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Commessa[] list = DAOFactory.getDAOFactory().getCommessaDAO().listCommessaByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Commessa[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Commessa getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Commessa p = DAOFactory.getDAOFactory().getCommessaDAO().getCommessaByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCommessa(com.coedil99.modello_di_dominio.Commessa p)
    {
        try {

            DAOFactory.getDAOFactory().getCommessaDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
