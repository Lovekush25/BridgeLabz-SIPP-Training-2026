class BankAccount {

    String accountNumber;
    String holder;
    double balance;

    static int totalAccounts = 0;

    BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited ₹" + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(holder + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void getStatement() {
        System.out.println("----------------------");
        System.out.println("Account : " + accountNumber);
        System.out.println("Holder  : " + holder);
        System.out.println("Balance : ₹" + balance);
    }

    public static void main(String[] args) {

        BankAccount a1 = new BankAccount("101","Rahul",10000);
        BankAccount a2 = new BankAccount("102","Aman",8000);
        BankAccount a3 = new BankAccount("103","Neha",12000);

        a1.deposit(2000);
        a1.withdraw(1000);
        a1.deposit(3000);
        a1.withdraw(500);
        a1.deposit(1000);

        a2.deposit(500);
        a2.withdraw(1000);
        a2.deposit(2500);
        a2.withdraw(700);
        a2.deposit(1500);

        a3.deposit(4000);
        a3.withdraw(2000);
        a3.deposit(1000);
        a3.withdraw(500);
        a3.deposit(500);

        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("Total Accounts = " + totalAccounts);
    }
}