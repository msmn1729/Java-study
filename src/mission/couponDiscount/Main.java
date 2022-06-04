package mission.couponDiscount;

public class Main {
    private static Product product1;
    private static Product product2;

    public static void main(String[] args) {
        testAddProduct();
        testUseCoupon();
    }

    public static void testAddProduct() {
        product1 = new Product("과자", 1000, 3); // 쿠폰 3개 적용 가능
        product2 = new Product("메론", 17000, 5);
    }

    public static void testUseCoupon() {
//        testBaroCoupon();
//        testSaleCoupon();
//        testDateCoupon();
        testAllCoupon();
    }

    public static void testBaroCoupon() {
        product1.createBaroCoupon();
        product1.createBaroCoupon();
        product1.createBaroCoupon();
        product1.createBaroCoupon(); // 최대 쿠폰 개수 초과로 생성 실패 알림

        product1.printAllCoupon();
        product1.notAvailableCoupon();
        product1.couponDiscountAppliedPrice();
    }

    public static void testSaleCoupon() {
        product1.resetCoupon();
        product1.createSaleCoupon();

        product1.printAllCoupon();
        product1.notAvailableCoupon();
        product1.couponDiscountAppliedPrice();

        product2.createSaleCoupon();
        product2.createSaleCoupon();

        product2.printAllCoupon();
        product2.notAvailableCoupon();
        product2.couponDiscountAppliedPrice();
    }

    public static void testDateCoupon() {
        product2.createDateCoupon(2022, 5, 25);
        product2.createDateCoupon(2022, 12, 25);

        product2.printAllCoupon();
        product2.notAvailableCoupon();
        product2.couponDiscountAppliedPrice();
    }

    public static void testAllCoupon() {
        product2.resetCoupon();

        product2.createSaleCoupon();
        product2.createDateCoupon(2022, 7, 7);
        product2.createBaroCoupon();

        product2.printAllCoupon();
        product2.notAvailableCoupon();
        product2.couponDiscountAppliedPrice();
    }
}
