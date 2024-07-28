package com.Entity;

import com.Model.CostSplitType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String costId;
    private String description;
    private double costAmount;

    @ManyToOne
    private User paidBy;

    @Enumerated(EnumType.STRING)
    private CostSplitType splitType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Split> splitList = new ArrayList<>();

    public Cost(String costId, String description, double costAmount, User paidBy, CostSplitType splitType, List<Split> splitList) {
        this.costId = costId;
        this.description = description;
        this.costAmount = costAmount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splitList.addAll(splitList);
    }


}
