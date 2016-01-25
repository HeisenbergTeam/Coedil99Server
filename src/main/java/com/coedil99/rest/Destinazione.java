package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 25/01/2016.
 */
@Path("destinazione")
public class Destinazione {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Destinazione[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.Destinazione[] list = DAOFactory.getDAOFactory().getDestinazioneDAO().listDestinazioneByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.Destinazione[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Destinazione getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.Destinazione p = DAOFactory.getDAOFactory().getDestinazioneDAO().getDestinazioneByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDestinazione(com.coedil99.modello_di_dominio.Destinazione p)
    {
        try {

            DAOFactory.getDAOFactory().getDestinazioneDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
