package com.logismiko.docs_auto_fill.dao.entities;

import jakarta.persistence.*;

@Entity
public class FirmDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String description;

    @ManyToOne
    @JoinColumn(name = "firm_entity_id")
    private FirmEntity firmEntity;

    public FirmEntity getFirmEntity() {
        return firmEntity;
    }

    public void setFirmEntity(FirmEntity firmEntity) {
        this.firmEntity = firmEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
