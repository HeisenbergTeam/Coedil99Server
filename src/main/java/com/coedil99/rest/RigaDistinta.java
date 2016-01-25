package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 25/01/2016.
 */
@Path("rigadistinta")
public class RigaDistinta {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.RigaDistinta[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.RigaDistinta[] list = DAOFactory.getDAOFactory().getRigaDistintaDAO().listRigaDistintaByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.RigaDistinta[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.RigaDistinta getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.RigaDistinta p = DAOFactory.getDAOFactory().getRigaDistintaDAO().getRigaDistintaByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRigaDistinta(com.coedil99.modello_di_dominio.RigaDistinta p)
    {
        try {

            DAOFactory.getDAOFactory().getRigaDistintaDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
