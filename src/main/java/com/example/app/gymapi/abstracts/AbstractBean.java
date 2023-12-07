package com.example.app.gymapi.abstracts;
import com.example.app.gymapi.interfaces.IBean;
import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractBean implements IBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

