package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 23/01/2016.
 */

@Path("descrizionepezzo")
public class DescrizionePezzo {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.DescrizionePezzo[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.DescrizionePezzo[] list = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().listDescrizionePezzoByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.DescrizionePezzo[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.DescrizionePezzo getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.DescrizionePezzo p = DAOFactory.getDAOFactory().getDescrizionePezzoDAO().getDescrizionePezzoByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRigaRDA(com.coedil99.modello_di_dominio.DescrizionePezzo p)
    {
        try {

            DAOFactory.getDAOFactory().getDescrizionePezzoDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

}
