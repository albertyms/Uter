package com.uter.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "drivers", schema="public")
public class Driver implements Serializable {

    @GenericGenerator(
            name = "driversGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "drivers_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            }
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "driversGenerator")
    private Long id;
    @NotEmpty(message = "Por favor ingrese el nombre")
    @NotNull
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Por favor ingrese el nombre")
    @NotNull
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "license")
    private String license;

    public Driver() {
    }

    public Driver(@NotEmpty(message = "Por favor ingrese el nombre") @NotNull String name, @NotEmpty(message = "Por favor ingrese el nombre") @NotNull String surName, String license) {
        this.name = name;
        this.surName = surName;
        this.license = license;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

}
