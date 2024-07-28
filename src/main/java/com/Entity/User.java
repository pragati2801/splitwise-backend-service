package com.Entity;

import jakarta.persistence.*;
import lombok.Getter;


public class User {

    String userId;
    String userName;


    private UserCostBalanceSheet userCostBalanceSheet;

    public User(String userId) {}

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.userCostBalanceSheet = new UserCostBalanceSheet();
    }


    public static class Cost {
    }
}
