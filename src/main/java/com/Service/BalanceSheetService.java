package com.Service;

import com.Entity.Split;
import com.Entity.User;
import com.Entity.UserCostBalanceSheet;
import com.Model.Balance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class BalanceSheetService {
    public void updateUserCostBalanceSheet(User costPaidBy, List<Split> splits, double totalExpenseAmount) {

        //update the total amount paid of the expense paid by user
        UserCostBalanceSheet paidByUserExpenseSheet = costPaidBy.getUserCostBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split : splits)
        {
            User userOwe = split.getUser();
            UserCostBalanceSheet oweUserCostSheet = userOwe.getUserCostBalanceSheet();
            double oweAmount = split.getAmount();

            if(costPaidBy.getUserId().equals(userOwe.getUserId()))
            {
                costPaidBy.getUserCostBalanceSheet().setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense()+oweAmount);
            }
            else{
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack()+oweAmount);
                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserVsBalance().containsKey(userOwe.getUserId()))
                {
                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else{
                    userOweBalance =new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack()+oweAmount );
                oweUserCostSheet.setTotalYouOwe(oweUserCostSheet.getTotalYouOwe() + oweAmount);
                oweUserCostSheet.setTotalYourExpense(oweUserCostSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if(oweUserCostSheet.getUserVsBalance().containsKey(costPaidBy.getUserId())){
                    userPaidBalance = oweUserCostSheet.getUserVsBalance().get(costPaidBy.getUserId());
                }
                else{
                    userPaidBalance = new Balance();
                    oweUserCostSheet.getUserVsBalance().put(costPaidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);


            }
        }


    }
    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserCostBalanceSheet userExpenseBalanceSheet =  user.getUserCostBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }


}
