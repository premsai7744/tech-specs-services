package com.premit.tech_specs_services.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Data
@Entity
@Table(name="device_specs")
public class DeviceSpecsEntity {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Lob
    @Column(name="spec_data")
    private String data;
}
