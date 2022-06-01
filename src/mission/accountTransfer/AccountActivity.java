package mission.accountTransfer;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity {
    private List<String> records = new ArrayList<>();

    // 예금
    public void deposit(Account account, int amount) {
        account.setBalance(account.getBalance() + amount);
        records.add("[예금성공] ID: " + account.getId() + ", 예금금액: " + amount + ", 잔액: " + account.getBalance());
    }

    // 출금
    public void withdraw(Account account, int amount) {
        int balance = account.getBalance() - amount;
        if (balance < 0) {
            records.add("[출금실패] ID: " + account.getId() + "의 잔액이 부족합니다.");
            return;
        }
        account.setBalance(balance);
        records.add("[출금성공] ID: " + account.getId() + ", 예금금액: " + amount + ", 잔액: " + account.getBalance());
    }

    // 이체
    public void transfer(Account accountFrom, Account accountTo, int amount) {
        int balance = accountFrom.getBalance() - amount;
        if (balance < 0) {
            records.add("[이체실패] ID: " + accountFrom.getId() + "의 잔액이 부족합니다.");
            return;
        }
        deposit(accountTo, amount);
        records.add("[이체성공] 보낸ID: " + accountFrom.getId() + ", 받은ID: " + accountTo.getId() + ", 보낸금액: " + amount);
    }

    // 거래내역 조회
    public void recordList() {
        for (String msg : records) {
            System.out.println(msg);
        }
        System.out.println("---------------------------------------");
    }
}
