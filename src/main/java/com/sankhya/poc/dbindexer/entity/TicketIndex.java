package com.sankhya.poc.dbindexer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "TicketIndex")
public class TicketIndex implements Indexable {

    @Id
    @Column(length = 64)
    private String id;
    private double amount;
    private String category;

    public TicketIndex(String id, double amount, String category) {
        this.id = id;
        this.amount = amount;
        this.category = category;
    }

    public TicketIndex() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
