package com.example.app.gymapi.auth;

import com.example.app.gymapi.abstracts.AbstractBean;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario extends AbstractBean {
}
