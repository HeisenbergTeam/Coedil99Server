package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 25/01/2016.
 */
@Path("sagoma")
public class Sagoma {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Sagoma[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Sagoma[] list = DAOFactory.getDAOFactory().getSagomaDAO().listSagomaByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Sagoma[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Sagoma getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Sagoma p = DAOFactory.getDAOFactory().getSagomaDAO().getSagomaByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSagoma(com.coedil99.modello_di_dominio.Sagoma p)
    {
        try {

            DAOFactory.getDAOFactory().getSagomaDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
