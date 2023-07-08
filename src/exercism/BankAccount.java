package exercism;

public class BankAccount {
    private int balance = 0;
    private boolean isAccountOpen = false;

    public void open() {
        isAccountOpen = true;
    }

    public int getBalance() throws BankAccountActionInvalidException {
        checkIfAccountIsNotClosed();
        return this.balance;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        checkIfAccountIsNotClosed();
        checkIsAmountIsPositive(amount);
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        checkIfAccountIsNotClosed();
        checkIfAccountIsNotEmpty();
        checkIsAmountIsPositive(amount);
        checkIfBalanceIsGreaterThenAmountToWithdraw(amount);

        this.balance -= amount;
    }

    public void close() {
        isAccountOpen = false;
    }

    private void checkIfAccountIsNotClosed() throws BankAccountActionInvalidException {
        if (!isAccountOpen) throw new BankAccountActionInvalidException("Account closed");
    }

    private void checkIsAmountIsPositive(int amount) throws BankAccountActionInvalidException {
        if (amount < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
    }

    private void checkIfBalanceIsGreaterThenAmountToWithdraw(int amount) throws BankAccountActionInvalidException {
        if (amount > balance)
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
    }

    private void checkIfAccountIsNotEmpty() throws BankAccountActionInvalidException {
        if (balance == 0) throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
    }

}
