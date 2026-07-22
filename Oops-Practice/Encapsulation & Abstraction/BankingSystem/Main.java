public class Main {

    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount();

        sa.setAccountNumber("S101");
        sa.setHolderName("Rahul");
        sa.setBalance(50000);
        sa.setInterestRate(5);

        sa.deposit(10000);
        sa.withdraw(5000);

        sa.displayAccountDetails();
        System.out.println(
                "Interest = " + sa.calculateInterest()
        );

        System.out.println();

        CurrentAccount ca = new CurrentAccount();

        ca.setAccountNumber("C201");
        ca.setHolderName("Aman");
        ca.setBalance(80000);
        ca.setMonthlyBonusRate(2);

        ca.deposit(5000);
        ca.withdraw(10000);

        ca.displayAccountDetails();
        System.out.println(
                "Interest = " + ca.calculateInterest()
        );
    }
}