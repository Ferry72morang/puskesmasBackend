package id.puskesmas.backend.service.impl;

import id.puskesmas.backend.model.Personal;
import id.puskesmas.backend.repo.PersonalRepository;
import id.puskesmas.backend.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    private PersonalRepository repository;

    @Override
    public List<Personal>listPersonal(){

        return repository.findAll();
    }

    @Override
    public void addPersonal(Personal personal){
         repository.save(personal);
    }
}
