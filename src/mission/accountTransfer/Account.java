package mission.accountTransfer;

public class Account {
    private Person person;
    private String id;
    private int balance;

    public Account(Person person, String id, int balance) {
        this.person = person;
        this.id = id;
        this.balance = balance;
    }

    public Person getPerson() {
        return person;
    }

    public String getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "person=" + person +
                ", id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}
