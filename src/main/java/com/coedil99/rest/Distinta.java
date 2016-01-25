package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 25/01/2016.
 */
@Path("distinta")
public class Distinta {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Distinta[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Distinta[] list = DAOFactory.getDAOFactory().getDistintaDAO().listDistintaByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Distinta[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Distinta getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Distinta p = DAOFactory.getDAOFactory().getDistintaDAO().getDistintaByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDistinta(com.coedil99.modello_di_dominio.Distinta p)
    {
        try {

            DAOFactory.getDAOFactory().getDistintaDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
