package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Igor on 25/01/2016.
 */
@Path("lavorazionepezzo")
public class LavorazionePezzo {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.LavorazionePezzo[] getAll()
    {
        try {

            com.coedil99.modello_di_dominio.LavorazionePezzo[] list = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().listLavorazionePezzoByQuery(null,null);
            return list;

        } catch (PersistentException e) {

            e.printStackTrace();
        }
        return new com.coedil99.modello_di_dominio.LavorazionePezzo[0];
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.LavorazionePezzo getIt(@PathParam("id") int cId) {
        try {
            com.coedil99.modello_di_dominio.LavorazionePezzo p = DAOFactory.getDAOFactory().getLavorazionePezzoDAO().getLavorazionePezzoByORMID(cId);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLavorazionePezzo(com.coedil99.modello_di_dominio.LavorazionePezzo p)
    {
        try {

            DAOFactory.getDAOFactory().getLavorazionePezzoDAO().save(p);

        }catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
