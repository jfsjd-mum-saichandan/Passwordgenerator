package com.submit.submit.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.submit.submit.model.registrations;
import com.submit.submit.repository.registrationsrepository;

@Service
public class registrationserviceimpl implements RegistrationService{
    @Autowired
    private registrationsrepository registrationrepository;

    public String createregistration(registrations registration){
        registrationrepository.save(registration);
        return "success";
    }
    public registrations getregistrationById(Integer id){
        Optional<registrations> findById=registrationrepository.findById(id);
        if(findById.isPresent()){
            return findById.get();
        }
    
        return null;
    }
    public Iterable<registrations> getAllregistrations(){
        return registrationrepository.findAll();
        
    }
    public registrations updateregistrationById(Integer id, registrations registration){
        Optional<registrations> registrationToUpdateOptional=registrationrepository.findById(id);
        if (!registrationToUpdateOptional.isPresent()) {
            return null;
          }
         
          
          registrations registrationToUpdate = registrationToUpdateOptional.get();
         
          if (registration.getFname() != null) {
            registrationToUpdate.setFname(registration.getFname());
          }
          if (registration.getMname() != null) {
            registrationToUpdate.setMname(registration.getMname());
          }
          if (registration.getLname() != null) {
            registrationToUpdate.setLname(registration.getLname());
          }
          registrations updatedsregistrations = registrationrepository.save(registrationToUpdate);
          return updatedsregistrations;
        }
        public registrations deleteregistrationById(Integer id) {
            Optional<registrations> registrationsToDeleteOptional = registrationrepository.findById(id);
            if (!registrationsToDeleteOptional.isPresent()) {
              return null;
            }
            registrations registrationToDelete = registrationsToDeleteOptional.get();
            registrationrepository.delete(registrationToDelete);
            return registrationToDelete;
          }
    }