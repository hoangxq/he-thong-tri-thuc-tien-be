package com.demo.service.utils;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.AbstractCondition;
import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MappingHelper {
    private ModelMapper modelMapper;

    public MappingHelper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T, H> void mapIfSourceNotNullAndStringNotBlank(T source, H destination){
        modelMapper.getConfiguration().setPropertyCondition(isStringNotBlank());
        modelMapper.map(source, destination);
    }

    private Condition<Object, Object>isStringNotBlank(){
        return new AbstractCondition<Object, Object>() {
            @Override
            public boolean applies(MappingContext<Object, Object> mappingContext) {
                if(mappingContext.getSource() instanceof String)
                    return StringUtils.isNoneBlank(String.valueOf(mappingContext.getSource()));
                return Objects.nonNull(mappingContext.getSource());
            }
        };
    }
}