package com.decorperson.calculadoradecorperson.dto;


import com.decorperson.calculadoradecorperson.entities.Budget;
import com.decorperson.calculadoradecorperson.entities.Furniture;


import java.math.BigDecimal;
import java.util.*;

public class BudgetDTO {


    private Long id;

    private String monthYear;
    private String clientFirstName;
    private String clientName;
    private Date date;
    private String budgetName;
    private Integer projectTime;
    private BigDecimal totalPrice;

    private List<Furniture> furnitures = new ArrayList<>();

    public BudgetDTO(){}
/*
    public BudgetDTO(Long id, String monthYear, String clientFirstName, String clientName, Date date, String budgetName, Integer projectTime, BigDecimal totalPrice, List<Furniture> furnitures) {
        this.id = id;
        this.monthYear = monthYear;
        this.clientFirstName = clientFirstName;
        this.clientName = clientName;
        this.date = date;
        this.budgetName = budgetName;
        this.projectTime = projectTime;
        this.totalPrice = totalPrice;
        this.furnitures = furnitures;
    }*/

    public BudgetDTO (Budget entity) {
        this.id = entity.getId();
        this.monthYear = entity.getMonthYear();
        this.clientFirstName = entity.getClientFirstName();
        this.clientName = entity.getClientName();
        this.date = entity.getDate();
        this.budgetName = entity.getBudgetName();
        this.projectTime = entity.getProjectTime();
        this.totalPrice = entity.getTotalPrice();

        for (Furniture item : entity.getFurnitures()) {
                      furnitures.add(item);
        }
        }


    public Long getId() {
        return id;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public String getClientName() {
        return clientName;
    }

    public Date getDate() {
        return date;
    }

    public String getBudgetName() {
        return budgetName;
    }

    public Integer getProjectTime() {
        return projectTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }
}

