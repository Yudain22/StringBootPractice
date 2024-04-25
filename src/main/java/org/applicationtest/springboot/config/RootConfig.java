package org.applicationtest.springboot.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                //아래는 톰캣과 다른 점, 톰캣과 달리 Loose 사용 JPA는 언제나 LOOSE
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

}
