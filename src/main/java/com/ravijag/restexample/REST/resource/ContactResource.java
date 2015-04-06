package com.ravijag.restexample.REST.resource;

import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Component;
import com.emc.ETAPPS.REST.dao.ContactDao;
import com.emc.ETAPPS.REST.model.Contact;

@Component
@Path("contacts")
public class ContactResource {
    
    private final Logger logger = LoggerFactory.getLogger(ContactResource.class);
    
    @Autowired
    private ContactDao contactDao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getContact(@PathParam("id") String contactId) {
        logger.debug("getContact, contactId: {}", contactId);
        return contactDao.find(contactId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact>  getAllContact() {
        //logger.debug("getContact, contactId: {}", contactId);
        return contactDao.findAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newContact(Contact contact) {
        logger.debug("newContact, contact: {}", contact);
        String id = contactDao.create(contact);
        URI createdUri = URI.create(id);
        return Response.created(createdUri).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/phone/{phonenumber}")
    public Response  updateContactPhone(@PathParam("id") String contactId, @PathParam("phonenumber") String newPhonenumber) {
        contactDao.updatePhone(contactId,newPhonenumber);
	 return Response.status(200).build();
    }
    
   /** @DELETE
    @Path("{id}")
    public void deleteContact(@PathParam("id") String contactId) {
        logger.debug("deleteContact, contact: {}", contactId);
        contactDao.delete(contactId);
    }**/

    @DELETE
    @Path("{id}")
    public Response  deleteContact(@PathParam("id") String contactId) {
        logger.debug("deleteContact, contact: {}", contactId);
        contactDao.delete(contactId);
	return Response.status(200).build();
    }

}
