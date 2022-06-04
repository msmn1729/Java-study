package mission.accountTransfer;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity {
    private List<String> records = new ArrayList<>();

    // 예금
    public void deposit(Account account, int amount) {
        if (!isAmountCheck(amount)) {
            return;
        }
        account.setBalance(account.getBalance() + amount);
        records.add("[예금성공] ID: " + account.getId() + ", 예금금액: " + amount + ", 잔액: " + account.getBalance());
    }

    // 출금
    public void withdraw(Account account, int amount) {
        if (!isAmountCheck(amount)) {
            return;
        }
        if (!isBalanceCheck(account.getBalance(), amount)) {
            records.add("[출금실패] ID: " + account.getId() + "의 잔액이 부족합니다.");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        records.add("[출금성공] ID: " + account.getId() + ", 예금금액: " + amount + ", 잔액: " + account.getBalance());
    }

    // 이체
    public void transfer(Account accountFrom, Account accountTo, int amount) {
        if (!isAmountCheck(amount)) {
            return;
        }
        withdraw(accountFrom, amount);
        deposit(accountTo, amount);
        records.add("[이체성공] 보낸ID: " + accountFrom.getId() + ", 받은ID: " + accountTo.getId() + ", 보낸금액: " + amount);
    }

    public boolean isAmountCheck(int amount) {
        if (amount < 0) {
            records.add("금액에 음수를 입력할 수 없습니다.");
            return false;
        }
        return true;
    }

    public boolean isBalanceCheck(int balance, int amount) {
        return balance >= amount;
    }

    // 거래내역 조회
    public void recordList() {
        for (String msg : records) {
            System.out.println(msg);
        }
        System.out.println("---------------------------------------");
    }
}
