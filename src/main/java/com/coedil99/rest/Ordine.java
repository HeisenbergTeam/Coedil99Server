package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 24/01/2016.
 */
@Path("ordine")
public class Ordine {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Ordine[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Ordine[] list = DAOFactory.getDAOFactory().getOrdineDAO().listOrdineByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Ordine[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Ordine getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Ordine p = DAOFactory.getDAOFactory().getOrdineDAO().getOrdineByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRigaRDA(com.coedil99.modello_di_dominio.Ordine p)
    {
        try {

            DAOFactory.getDAOFactory().getOrdineDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
