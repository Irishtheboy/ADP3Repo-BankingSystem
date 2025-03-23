package za.co.BankingSystem.Domain;

public class SavingsAccount{
    //1.Configuring the private attributes of the savings account POJO
    private double interestRate;
    private double minimimBalance;
    private int withdrawLimit;

    //7. Constructing the instance of the Savings Account constructor
    public SavingsAccount(Builder builder){
        this.interestRate = builder.interestRate;
        this.minimimBalance = builder.minimimBalance;
        this.withdrawLimit = builder.withdrawLimit;
    }

    //2.Constructing the Builder Inner class to construct the POJO constructor
    public static class Builder{
        private double interestRate;
        private double minimimBalance;
        private int withdrawLimit;

        //3.Configuring the Builder constructor with its variable instances
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

        //4.Creating the toString to display the information of the constructed instance
        public String toString(){
            return "Savings Account: [\n" +
            "Interest Rate: " + interestRate + ", \n" +
            "Minimum Balance (R): " + minimimBalance + ", \n" +
            "Withdraw Limit: " + withdrawLimit + "\n]";
        }

        //5. Creating the Copy method to duplicate the data from the POJO
        public Builder copy(){
            this.interestRate = interestRate;
            this.minimimBalance = minimimBalance;
            this.withdrawLimit = withdrawLimit;
            return this;
        }
        //6. Constructing the instance of the Savings Account object using the Builder
        public SavingsAccount build(){
            return new SavingsAccount(this);
        }
    }

}
