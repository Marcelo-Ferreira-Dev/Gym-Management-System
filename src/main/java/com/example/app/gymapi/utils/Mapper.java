package com.example.app.gymapi.utils;
import com.example.app.gymapi.abstracts.AbstractBean;
import com.example.app.gymapi.abstracts.AbstractDto;
import com.example.app.gymapi.interfaces.IMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

@Component
public  class Mapper<B extends AbstractBean,D extends AbstractDto>  implements IMapper<B ,D>  {
    private ModelMapper modelMapper;
    public Mapper(){
        modelMapper=new ModelMapper();
    }


    public B toBean(D dto) {
        return modelMapper.map(dto, new TypeToken<B>() {}.getType());
    }

    public D toDto(B bean) {
        return modelMapper.map(bean, new TypeToken<D>() {}.getType());
    }
}
