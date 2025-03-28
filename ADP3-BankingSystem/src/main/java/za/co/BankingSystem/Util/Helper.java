package za.co.BankingSystem.Util;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        if(s.isEmpty() || s == null){
            return true;
        }
        else return false;
    }

    //Setting Validation method for the account
    //1. Validating the Account Number
    public static boolean isValidAccountNumber(String accountNumber){
        if(accountNumber.length() < 13 || accountNumber == null){
            return false;
        }
        else return true;
    }
    //2. Validating the Account Type
    public static boolean isValidAccountType(String accountType){
        switch(accountType){
            case "Checking Account": return true;
            case "Savings Account":return true;
            default: return false;
        }
    }

    //3. Validating the Users account balance
    public static boolean isValidMinimumBalance(double minimumBalance) {
        return minimumBalance >= 0;
    }
    //4.Validating the Savings account interest rate
    public static boolean isValidInterestRate(double interestRate) {
        return interestRate > 0;
    }
}
