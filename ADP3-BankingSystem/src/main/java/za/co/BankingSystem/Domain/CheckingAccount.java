package za.co.BankingSystem.Domain;

public class CheckingAccount {
    private String checkingAccountID;
    private double overdraftLimit;
    private double monthlyFee;
    private String debitCardNumber;

    private CheckingAccount() {

    }

    private CheckingAccount(Builder builder) {
        this.checkingAccountID = builder.checkingAccountID;
        this.overdraftLimit = builder.overdraftLimit;
        this.monthlyFee = builder.monthlyFee;
        this.debitCardNumber = builder.debitCardNumber;

    }

    public String getCheckingAccountID() {return checkingAccountID;}

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }



    @Override
    public String toString() {
        return "CheckingAccount{" +
                "checkingAccountId='" + checkingAccountID + '\'' +
                ", overdraftLimit=" + overdraftLimit +
                ", monthlyFee=" + monthlyFee +
                ", debitCardNumber='" + debitCardNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String checkingAccountID;
        private double overdraftLimit;
        private double monthlyFee;
        private String debitCardNumber;

        public Builder setCheckingAccountID(String checkingAccountID) {
            this.checkingAccountID = checkingAccountID;
            return this;
        }

        public Builder setOverdraftLimit(double overdraftLimit) {
            this.overdraftLimit = overdraftLimit;
            return this;
        }

        public Builder setMonthlyFee(double monthlyFee) {
            this.monthlyFee = monthlyFee;
            return this;
        }

        public Builder setDebitCardNumber(String debitCardNumber) {
            this.debitCardNumber = debitCardNumber;
            return this;
        }

        public Builder copy(CheckingAccount checkingAccount) {
            this.checkingAccountID = checkingAccount.checkingAccountID;
            this.overdraftLimit = checkingAccount.overdraftLimit;
            this.monthlyFee = checkingAccount.monthlyFee;
            this.debitCardNumber = checkingAccount.debitCardNumber;
            return this;
        }

        public CheckingAccount build() {
            return new CheckingAccount(this);
        }
    }


}
