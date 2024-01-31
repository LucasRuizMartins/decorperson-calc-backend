package com.decorperson.calculadoradecorperson.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tb_budget")
public class Budget {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String monthYear;
    private String clientFirstName;
    private String clientName;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date date;

    private String budgetName;

    private Integer projectTime;

    private BigDecimal totalPrice;

    @ManyToMany
    @JoinTable(name = "tb_budget_furniture",
    joinColumns = @JoinColumn(name = "budget_id"),
    inverseJoinColumns = @JoinColumn(name = "furniture_id"))
    private Set<Furniture> furnitures = new HashSet<>();


    public Budget(){}

    public Budget(Long id, String monthYear, String clientFirstName, String clientName, Date date, String budgetName, Integer projectTime, BigDecimal totalPrice, Set<Furniture> furnitures) {
        this.id = id;
        this.monthYear = monthYear;
        this.clientFirstName = clientFirstName;
        this.clientName = clientName;
        this.date = date;
        this.budgetName = budgetName;
        this.projectTime = projectTime;
        this.totalPrice = totalPrice;
        this.furnitures = furnitures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Integer getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(Integer projectTime) {
        this.projectTime = projectTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Furniture> getFurnitures() {
        return furnitures;
    }
}
