package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 23/01/2016.
 */
@Path("rigarda")
public class RigaRDA {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.RigaRDA[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.RigaRDA[] list = DAOFactory.getDAOFactory().getRigaRDADAO().listRigaRDAByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.RigaRDA[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.RigaRDA getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.RigaRDA p = DAOFactory.getDAOFactory().getRigaRDADAO().getRigaRDAByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRigaRDA(com.coedil99.modello_di_dominio.RigaRDA p)
    {
        try {

            DAOFactory.getDAOFactory().getRigaRDADAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
