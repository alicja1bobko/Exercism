package exercism;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final AtomicBoolean isOpen = new AtomicBoolean();

    private int amount = 0;

    public void open() {
        isOpen.set(true);
    }

    public void close() {
        isOpen.set(false);
    }

    public int getBalance() throws BankAccountActionInvalidException {
        lock.readLock().lock();
        try {
            if (!isOpen.get()) {
                throw new BankAccountActionInvalidException("Account closed");
            }

            return amount;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void deposit(final int depositAmount) throws BankAccountActionInvalidException {
        lock.writeLock().lock();
        try {
            if (!isOpen.get()) {
                throw new BankAccountActionInvalidException("Account closed");
            }

            if (depositAmount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }

            amount += depositAmount;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(final int withdrawAmount) throws BankAccountActionInvalidException {
        lock.writeLock().lock();
        try {
            if (!isOpen.get()) {
                throw new BankAccountActionInvalidException("Account closed");
            }

            if (amount == 0) {
                throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
            }

            if (withdrawAmount > amount) {
                throw new BankAccountActionInvalidException(
                        "Cannot withdraw more money than is currently in the account");
            }

            if (withdrawAmount < 0) {
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            }

            amount -= withdrawAmount;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
