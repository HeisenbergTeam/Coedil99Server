package com.coedil99.rest;

import com.coedil99.modello_di_dominio.DAOFactory;
import org.orm.PersistentException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Created by Igor on 13/01/2016.
 */
@Path("pezzo")
public class Pezzo {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.coedil99.modello_di_dominio.Pezzo getIt() {
        try {
            com.coedil99.modello_di_dominio.Pezzo p = DAOFactory.getDAOFactory().getPezzoDAO().getPezzoByORMID(1);
            return p;

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        return "ciao";
    }

}
