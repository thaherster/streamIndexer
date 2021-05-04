package com.sankhya.poc.dbindexer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "Ticket")
public class Ticket implements Indexable {

    @Id
    private UUID id;
    private double amount;
    private String category;

    public Ticket(UUID id, double amount, String category) {
        this.id = id;
        this.amount = amount;
        this.category = category;
    }

    public Ticket() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
