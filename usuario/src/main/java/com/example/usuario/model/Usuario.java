/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author orlando.rubio
 */

@Entity
@Table(name = "Usuario")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAT", "updatedAT"}, allowGetters = true)

public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    @NotBlank
    private String Nombre;
    
    @NotBlank
    private String Apellido;
    
    @NotBlank
    private int Edad;
    
    @NotBlank
    private String Cargo;
    
    @NotBlank
    private String Password;
    
    @NotBlank
    private String email;
    
    @NotBlank
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    
    
    
    
    
    
    
}
