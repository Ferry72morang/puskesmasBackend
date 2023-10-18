package id.puskesmas.backend.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.puskesmas.backend.model.KafkaLogTable;
import id.puskesmas.backend.model.Personal;
import id.puskesmas.backend.model.ProduceDto;
import id.puskesmas.backend.repo.KafkaLogTableRepository;
import id.puskesmas.backend.util.GlobalVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PersonalConsumerServiceImpl {
    private final Logger logger = LoggerFactory.getLogger(PersonalServiceImpl.class);
    @Value("${useKafka}")
    String useKafka;

    @Autowired
    private KafkaLogTableRepository logRepo;

    @KafkaListener(topics = "${spring.kafka.topics}",groupId = "ferry_project")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        if(Boolean.parseBoolean(useKafka)){
            Gson gson = new Gson();
            ProduceDto produceDto = gson.fromJson(message, ProduceDto.class);
            logger.info("#### -> Consumed message -> " + produceDto);

            if(produceDto.getAction().toUpperCase().equals(GlobalVariable.actionInsert)){
              sendToLog(produceDto);
            }
        }
    }

    public void sendToLog(ProduceDto produceDto){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        KafkaLogTable model = new KafkaLogTable();
        model.setAction(produceDto.getAction());
        model.setFromTable(produceDto.getFromTable());
        model.setLog(gson.toJson(produceDto));
       logRepo.save(model);
    }
}
