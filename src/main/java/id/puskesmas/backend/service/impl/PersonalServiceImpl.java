package id.puskesmas.backend.service.impl;

import com.google.gson.Gson;
import id.puskesmas.backend.model.Personal;
import id.puskesmas.backend.model.ProduceDto;
import id.puskesmas.backend.repo.PersonalRepository;
import id.puskesmas.backend.service.PersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {
    private static final Logger logger = LoggerFactory.getLogger(PersonalServiceImpl.class);

    @Value("${spring.kafka.topics}")
    String TOPIC;

    @Value("${useKafka}")
    String useKafka;

    @Autowired
    private KafkaTemplate<String, String>kafkaTemplate;

    public void sendData(ProduceDto produceDto) {
        Gson gson = new Gson();

        logger.info(String.format("#### -> Producing data -> %s", gson.toJson(produceDto)));
        if (Boolean.parseBoolean(useKafka))
            this.kafkaTemplate.send(TOPIC, gson.toJson(produceDto));
    }

    @Autowired
    private PersonalRepository repository;

    @Override
    public List<Personal>listPersonal(){

        return repository.findAll();
    }

    @Override
    public void addPersonal(Personal personal){
         repository.save(personal);
         ProduceDto produceDto = new ProduceDto();
         produceDto.setAction("POST");
         produceDto.setFromTable("personal");
         produceDto.setToTable(null);
         produceDto.setPayload(personal);
         if(Boolean.parseBoolean(useKafka)){
             sendData(produceDto);
         }
    }
}
