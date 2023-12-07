package com.example.app.gymapi.interfaces;

import com.example.app.gymapi.abstracts.AbstractBean;
import com.example.app.gymapi.abstracts.AbstractDto;
import org.springframework.stereotype.Component;

@Component
public interface IMapper<B extends AbstractBean,D extends AbstractDto> {
    public B toBean(D dto);
    public D toDto(B bean);
}
