package com.ravijag.restexample.REST.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import com.emc.ETAPPS.REST.model.Contact;
import java.util.List;

@Component
public class ContactDao {
    
    private final Logger logger = LoggerFactory.getLogger(ContactDao.class);

     private static final String COLLECTION = "contact";
            
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Contact find(String id) {
        logger.debug("find, id: {}", id);
        return mongoTemplate.findById(id, Contact.class);
    }
    
    public List findAll() {
        //return mongoTemplate.findById(id, Contact.class);
	return (List) mongoTemplate.findAll(Contact.class,COLLECTION);
    }
    public String create(Contact contact) {
        logger.debug("create, contact: {}", contact);
        mongoTemplate.insert(contact);
        logger.debug("created contact with id: {}", contact.getId());
        return contact.getId();
    }
    
    public void delete(String id) {
        logger.debug("delete, id: {}", id);
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Contact.class);
    }
    
    public void updatePhone(String id, String  newPhone){ 
        //logger.debug("updatePriority, id: {}, newPriority: {}", id, newPriority);
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.updateFirst(query, Update.update("phone", newPhone), Contact.class);

    }	

    public void updatePriority(String id, String  newPhone) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.updateFirst(query, Update.update("phone", newPhone), Contact.class);
    }
}
