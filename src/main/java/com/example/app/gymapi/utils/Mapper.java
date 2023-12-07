package com.example.app.gymapi.utils;
import com.example.app.gymapi.abstracts.AbstractBean;
import com.example.app.gymapi.abstracts.AbstractDto;
import com.example.app.gymapi.interfaces.IMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public  class Mapper<B extends AbstractBean,D extends AbstractDto>  implements IMapper<B ,D>  {
    private ModelMapper modelMapper;
    public Mapper(){
        modelMapper=new ModelMapper();
    }


    public B toBean(D dto, Class<B> beanClass) {
        return modelMapper.map(dto, beanClass);
    }

    public D toDto(B bean, Class<D> dtoClass) {
        return modelMapper.map(bean, dtoClass);
    }
}
