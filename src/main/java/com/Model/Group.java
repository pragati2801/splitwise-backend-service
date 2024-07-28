package com.Model;

import com.Controller.CostController;
import com.Entity.Cost;
import com.Entity.Split;
import com.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Cost> costList;
    CostController costController;

    Group(){
        groupMembers = new ArrayList<>();
        costList = new ArrayList<>();
        costController = new CostController();
    }
    public void addMember(User member){
        groupMembers.add(member);
    }







    public Cost createExpense(String expenseId, String description, double costAmount,
                              List<Split> splitDetails, CostSplitType splitType, User paidByUser) {

        if (splitType == CostSplitType.EQUAL) {

        }

        Cost cost = costController.createExpense(expenseId, description, costAmount, splitDetails, splitType,  paidByUser);
        costList.add(cost);

        return cost;


    }

}
