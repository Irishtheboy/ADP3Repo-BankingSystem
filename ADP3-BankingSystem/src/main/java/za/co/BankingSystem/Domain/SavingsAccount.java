package za.co.BankingSystem.Domain;

public class SavingsAccount{

    private double interestRate;
    private double minimimBalance;
    private int withdrawLimit;


    public SavingsAccount(Builder builder){
        this.interestRate = builder.interestRate;
        this.minimimBalance = builder.minimimBalance;
        this.withdrawLimit = builder.withdrawLimit;
    }


    public static class Builder{
        private double interestRate;
        private double minimimBalance;
        private int withdrawLimit;


        public Builder interestRate(double interestRate){
            this.interestRate = interestRate;
            return this;
        }
        public Builder minimumBalance(double minimimBalance){
            this.minimimBalance = minimimBalance;
            return this;
        }
        public Builder withdrawLimit(int withdrawLimit){
            this.withdrawLimit = withdrawLimit;
            return this;
        }


        public String toString(){
            return "Savings Account: [\n" +
            "Interest Rate: " + interestRate + ", \n" +
            "Minimum Balance (R): " + minimimBalance + ", \n" +
            "Withdraw Limit: " + withdrawLimit + "\n]";
        }


        public Builder copy(){
            this.interestRate = interestRate;
            this.minimimBalance = minimimBalance;
            this.withdrawLimit = withdrawLimit;
            return this;
        }

        public SavingsAccount build(){
            return new SavingsAccount(this);
        }
    }

}
