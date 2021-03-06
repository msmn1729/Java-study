package mission.shareDocument;

import java.util.ArrayList;

public class AccountDB {
    private ArrayList<Account> accounts = new ArrayList<>();

    public AccountDB() {
        accounts.add(new Account("a", "a@email.com"));
        accounts.add(new Account("b", "b@email.com"));
        accounts.add(new Account("c", "c@email.com"));
        accounts.add(new Account("d", "d@email.com"));
        accounts.add(new Account("e", "e@email.com"));
    }

    public Account findByAccount(Account account) throws RuntimeException {
        if (accounts.contains(account)) {
            return account;
        }

        throw new RuntimeException(account + " 는 DB에 존재하지 않는 계정입니다.");
    }

    public boolean isExist(Account account) {
        return accounts.contains(account);
    }

    @Override
    public String toString() {
        return "AccountDB{" +
                "accounts=" + accounts +
                '}';
    }
}
