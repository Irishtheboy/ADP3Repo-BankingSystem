package za.co.BankingSystem.Domain;

public class CheckingAccount {
    private double overdraftLimit;
    private double monthlyFee;
    private String debitCardNumber;

    private CheckingAccount() {

    }

    private CheckingAccount(Builder builder) {
        this.overdraftLimit = builder.overdraftLimit;
        this.monthlyFee = builder.monthlyFee;
        this.debitCardNumber = builder.debitCardNumber;
    }


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
                "overdraftLimit=" + overdraftLimit +
                ", monthlyFee=" + monthlyFee +
                ", debitCardNumber='" + debitCardNumber + '\'' +
                '}';
    }

    public static class Builder {
        private double overdraftLimit;
        private double monthlyFee;
        private String debitCardNumber;

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
            this.overdraftLimit = checkingAccount.overdraftLimit;
            this.monthlyFee = checkingAccount.monthlyFee;
            this.debitCardNumber = checkingAccount.debitCardNumber;
            return this;
        }

        public CheckingAccount build() {
            return new CheckingAccount();
        }
    }


}
