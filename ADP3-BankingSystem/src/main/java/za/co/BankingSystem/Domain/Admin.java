package za.co.BankingSystem.Domain;

public class Admin {
    public String adminID;
    private  String name;
    private  String email;
    private  String role;
    private  String contactNumber;

    private Admin(Builder builder) {
        this.adminID = builder.adminID;
        this.name = builder.name;
        this.email = builder.email;
        this.role = builder.role;
        this.contactNumber = builder.contactNumber;
    }



    public static class Builder {
        private String adminID;
        private String name;
        private String email;
        private String role;
        private String contactNumber;

        public Builder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }


}
