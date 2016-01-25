package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by Igor on 13/01/2016.
 */
@Path("pezzo")
public class Pezzo {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Pezzo[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Pezzo[] list = DAOFactory.getDAOFactory().getPezzoDAO().listPezzoByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Pezzo[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Pezzo getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Pezzo p = DAOFactory.getDAOFactory().getPezzoDAO().getPezzoByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPezzo(com.coedil99.modello_di_dominio.Pezzo p)
    {
        try {

            DAOFactory.getDAOFactory().getPezzoDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

}
