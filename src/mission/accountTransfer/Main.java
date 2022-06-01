package mission.accountTransfer;

public class Main {
    private static Person person1 = new Person("park", 20, "male");
    private static Account account1 = new Account(person1, "id77", 70000);
    private static Person person2 = new Person("kim", 30, "female");
    private static Account account2 = new Account(person2, "id55", 50000);
    private static AccountActivity activity = new AccountActivity();

    public static void main(String[] args) {
        testDeposit();
        testWithdraw();
        testTransfer();
    }

    public static void testDeposit() {
        activity.deposit(account1, 30000);
        activity.recordList();
    }

    public static void testWithdraw() {
        activity.withdraw(account2, 5000);
        activity.withdraw(account2, 1000000);
        activity.recordList();
    }

    public static void testTransfer() {
        activity.transfer(account1, account2, 30000);
        activity.transfer(account1, account2, 3000000);
        activity.recordList();
    }
}
