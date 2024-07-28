package com.Entity;

import com.Model.Balance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
public class UserCostBalanceSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @CollectionTable(name = "user_balance", joinColumns = @JoinColumn(name = "balance_sheet_id"))
    @MapKeyColumn(name = "user_id")

     private Map<String, Balance> userVsBalance;


    private double totalYouOwe;
    private double totalYourExpense;
    private double totalYouGetBack;
    private double totalPayment;

    public UserCostBalanceSheet() {
        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }


}
