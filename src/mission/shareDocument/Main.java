package mission.shareDocument;

public class Main {
    private static AccountDB accountDB = new AccountDB();

    public static void main(String[] args) {
        testFindByAccount();
        testDocumentRead();
        testAddPermission();
    }

    public static void testFindByAccount() {
        try {
            accountDB.findByAccount(new Account("a", "a@email.com")); // DB에 존재
            accountDB.findByAccount(new Account("qqq", "a@email.com")); // DB에 미존재
        } catch (RuntimeException runtimeException) {
            runtimeException.printStackTrace();
        }
    }

    public static void testDocumentRead() {
        Account account1 = new Account("a", "a@email.com");
        Account account2 = new Account("qqq", "c@email.com");
        Document document1 = new Document(account1, "nice day!");
        Document document2 = new Document(account2, "nono"); // DB에 없는 계정이므로 문서 생성 불가
        document1.printPermissionList();

        document1.read(account1);
        document1.read(account2); // 권한이 없는 계정은 읽기 불가
    }

    public static void testAddPermission() {
        Account account1 = accountDB.findByAccount(new Account("a", "a@email.com"));
        Account account2 = accountDB.findByAccount(new Account("c", "c@email.com"));
        Document document = new Document(account1, "happy day!"); // account1 계정만 접근 가능
        document.read(account1); // 읽기 가능

        document.read(account2); // account2 읽기 불가
        document.addPermission(account2); // account2 읽기 권한 부여
        document.read(account2); // account2 읽기 가능
    }
}
