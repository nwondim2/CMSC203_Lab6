public class SavingsAccount extends BankAccount {
    private double rate = 2.5;
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, double amount) {
        super(name, amount);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        this.savingsNumber = oldAccount.savingsNumber + 1;
        this.accountNumber = oldAccount.getAccountNumber().substring(0, oldAccount.getAccountNumber().lastIndexOf('-')) + "-" + this.savingsNumber;
    }

    public void postInterest() {
        double interest = getBalance() * rate / 100 / 12;
        deposit(interest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
