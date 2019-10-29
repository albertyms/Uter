package com.uter.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "vehicles", schema="public")
public class Vehicle implements Serializable {

    @GenericGenerator(
            name = "vehiclesGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "vehicles_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            }
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "vehiclesGenerator")
    private Long id;
    @NotNull
    @NotEmpty(message = "Por favor ingrese el nombre de la marca")
    @Column(name = "brand")
    private String brand;
    @NotNull
    @NotEmpty(message = "Por favor ingrese el nombre del model")
    @Column(name = "model")
    private String model;
    @NotNull
    @NotEmpty(message = "Por favor ingrese la placa")
    @Column(name = "plate")
    private String plate;
    @Column(name = "license_required")
    private String licenseRequired;

    public Vehicle() {
    }

    public Vehicle(@NotNull @NotEmpty(message = "Por favor ingrese el nombre de la marca") String brand, @NotNull @NotEmpty(message = "Por favor ingrese el nombre del model") String model, @NotNull @NotEmpty(message = "Por favor ingrese la placa") String plate, String licenseRequired) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.licenseRequired = licenseRequired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getLicenseRequired() {
        return licenseRequired;
    }

    public void setLicenseRequired(String licenseRequired) {
        this.licenseRequired = licenseRequired;
    }

}
