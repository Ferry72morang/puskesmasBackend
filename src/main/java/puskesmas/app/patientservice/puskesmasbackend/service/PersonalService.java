package puskesmas.app.patientservice.puskesmasbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import puskesmas.app.patientservice.puskesmasbackend.model.Personal;
import puskesmas.app.patientservice.puskesmasbackend.repository.PersonalRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class PersonalService {
    private static final Logger logger = LoggerFactory.getLogger(PersonalService.class);

    @Autowired
    PersonalRepository personalRepository;

    public List<Personal> getListPersonal(){
        List<Personal> listData = personalRepository.findAll();


        listData = listData.stream()
                .map(personal -> {
                    LocalDateTime localDateTime = personal.getPersonalBirthDate().toLocalDateTime();
                    LocalDate localDate = localDateTime.toLocalDate();
//                    personal.setPersonalBirthDate(new Timestamp(localDate.));
                    return personal;
                })
                .collect(Collectors.toList());

        UUID uuid = UUID.randomUUID();
        String randomId = uuid.toString().toUpperCase().replace("-","");

        return listData;
    }
}
