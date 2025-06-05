package org.indmocoil.services.configurations;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.cloud.spring.data.datastore.core.DatastoreTemplate;


@Configuration
public class EssayConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public Datastore datastore() {
        return DatastoreOptions.newBuilder()
                .setProjectId("fugitivedemocracy")
                .setDatabaseId("indmocoildb")
                .build()
                .getService();
    }



//    @Bean
//    public DatastoreTemplate datastoreTemplate(Datastore dstore) {
//        return new DatastoreTemplate(dstore);
//    }


}
