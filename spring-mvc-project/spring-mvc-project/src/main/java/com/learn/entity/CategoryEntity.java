package com.learn.entity;

import com.learn.enums.StatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" , updatable = false , nullable = false , unique = true)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

    @Column(name = "ACTIVE_STATUS")
    @Enumerated(EnumType.STRING)
    private StatusEnum activeStatus;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public StatusEnum getActiveStatus() {
        return activeStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setActiveStatus(StatusEnum activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
