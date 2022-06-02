package mission.shareDocument;

import java.util.Arrays;

public class Document {
    private String description;
    private Account[] permissionAccounts = new Account[2];

    public Document(Account account, String description) {
        // DB에 없는 유저는 문서 생성 불가
        if (!new AccountDB().isExist(account)) {
            System.err.println(account + " 는 DB에 등록되지 않은 계정이므로 문서를 생성할 수 없습니다.");
            return;
        }
        permissionAccounts[0] = account;
        this.description = description;
        System.out.println(account + " 계정에 문서가 생성되었습니다.");
    }

    public void addPermission(Account account) throws RuntimeException {
        if (!new AccountDB().isExist(account)) {
            throw new RuntimeException(account + " 는 DB에 등록되지 않은 계정이므로 권한을 추가할 수 없습니다.");
        }

        boolean enoughSizeCheck = (permissionAccounts[permissionAccounts.length - 1] == null);

        // 권한 공간이 부족한 경우 2배 늘림
        if (!enoughSizeCheck) {
            permissionAccounts = increaseArraySizeDouble(permissionAccounts);
        }

        // 퍼미션 등록
        for (int i = 0; i < permissionAccounts.length; i++) {
            if (permissionAccounts[i] != null) {
                continue;
            }
            permissionAccounts[i] = account;
            System.out.println(account + " 계정에 문서 읽기 권한이 부여되었습니다.");
            return;
        }
    }

    public Account[] increaseArraySizeDouble(Account[] permissionAccounts) {
        int prevSize = permissionAccounts.length;
        Account[] accounts = new Account[prevSize * 2];

        for (int i = 0; i < prevSize; i++) {
            accounts[i] = permissionAccounts[i];
        }

        return accounts;
    }

    public void read(Account account) {
        for (int i = 0; i < permissionAccounts.length; i++) {
            if (permissionAccounts[i] == null) {
                continue;
            }
            if (permissionAccounts[i].equals(account)) {
                System.out.println("접근 계정: " + account + ", 문서내용: " + description + "\n");
                return;
            }
        }
        System.err.println(account + " 계정은 문서 읽기 권한이 없습니다.");
    }

    public void printPermissionList() {
        System.out.println("[문서 읽기 권한 조회] " + Arrays.toString(permissionAccounts));
    }
}
