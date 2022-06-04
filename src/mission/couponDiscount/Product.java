package mission.couponDiscount;

import java.time.LocalDate;

public class Product {
    private String name;
    private int price;
    private Coupon[] coupons;

    public Product(String name, int price, int couponCount) {
        this.name = name;
        this.price = price;
        coupons = new Coupon[couponCount];
    }

    public void resetCoupon() {
        coupons = new Coupon[coupons.length];
    }

    public void createBaroCoupon() {
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] != null) {
                continue;
            }
            coupons[i] = new BaroCoupon();
            return;
        }
        createCouponFail();
    }

    public void createSaleCoupon() {
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] != null) {
                continue;
            }
            coupons[i] = new SaleCoupon();
            return;
        }
        createCouponFail();
    }

    public void createDateCoupon(int year, int month, int day) {
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] != null) {
                continue;
            }
            coupons[i] = new DateCoupon(LocalDate.of(year, month, day));
            return;
        }
        createCouponFail();
    }

    public void createCouponFail() {
        System.err.println("[생성실패] 쿠폰 최대 생성 개수는 " + coupons.length + "개 입니다.");
    }

    public int getPrice() {
        return price;
    }

    public void notAvailableCoupon() {
        System.out.println("[적용 불가 쿠폰 목록]");
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            if (!coupons[i].isAvailableApply(price)) {
                System.out.println(coupons[i].getName());
            }
        }
        System.out.println("--------------------------------");
    }

    public void couponDiscountAppliedPrice() {
        System.out.println("[쿠폰 할인 적용가]");
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            if (coupons[i].isAvailableApply(price)) {
                int discountedPrice = price - coupons[i].discountPrice(price);
                System.out.println(coupons[i].getName() + " 적용가: " + price + " - " + coupons[i].discountPrice(price) + " = " + discountedPrice);
            }
        }
        System.out.println("--------------------------------");
    }

    public void printAllCoupon() {
        System.out.println("[전체 쿠폰 목록]");
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            System.out.println("쿠폰명: " + coupons[i].getName() + ", 우선순위: " + coupons[i].priorityCheck());
        }
        System.out.println("--------------------------------");
    }
}
