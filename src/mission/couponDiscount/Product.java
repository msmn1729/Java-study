package mission.couponDiscount;

import java.time.LocalDate;
import java.util.Arrays;

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
        createCoupon(new BaroCoupon());
    }

    public void createSaleCoupon() {
        createCoupon(new SaleCoupon());
    }

    public void createDateCoupon(int year, int month, int day) {
        createCoupon(new DateCoupon(LocalDate.of(year, month, day)));
    }

    public void createCoupon(Coupon coupon) {
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] != null) {
                continue;
            }
            coupons[i] = coupon;
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
                System.out.println(coupons[i].getClass().getSimpleName());
            }
        }
        System.out.println("--------------------------------");
    }

    public void allCouponDiscountAppliedPrice() {
        System.out.println("[전체 쿠폰 할인 적용]");
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            if (coupons[i].isAvailableApply(price)) {
                int discountedPrice = price - coupons[i].discountPrice(price);
                System.out.println(coupons[i].getClass().getSimpleName() + " 적용가: " + price + " - " + coupons[i].discountPrice(price) + " = " + discountedPrice);
            }
        }
        System.out.println("--------------------------------");
    }

    public int couponDiscountAppliedPrice() {
        System.out.println("[최종 쿠폰 적용가]");

        for (Coupon coupon : couponPrioritySort()) {
            if (coupon == null || !coupon.isAvailableApply(price)) {
                continue;
            }
            int discountedPrice = price - coupon.discountPrice(price);
            System.out.println(coupon.getClass().getSimpleName() + " 적용가: " + price + " - " + coupon.discountPrice(price) + " = " + discountedPrice);
            price -= coupon.discountPrice(price);
        }
        return price;
    }

    public Coupon[] couponPrioritySort() {
        int count = 0;

        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            count++;
        }

        Coupon[] validCoupons = new Coupon[count];
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            validCoupons[--count] = coupons[i];
        }
        Arrays.sort(validCoupons);
        return validCoupons;
    }

    public int couponPriorityDiscountAppliedPrice(int price, int priority) {
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null || !coupons[i].isAvailableApply(price)) {
                continue;
            }
            if (coupons[i].priorityCheck() == priority) {
                int discountedPrice = price - coupons[i].discountPrice(price);
                System.out.println(coupons[i].getClass().getSimpleName() + " 적용가: " + price + " - " + coupons[i].discountPrice(price) + " = " + discountedPrice);
                price -= coupons[i].discountPrice(price);
            }
        }
        return price;
    }

    public void printAllCoupon() {
        System.out.println("[전체 쿠폰 목록]");
        for (int i = 0; i < coupons.length; i++) {
            if (coupons[i] == null) {
                continue;
            }
            System.out.println("쿠폰명: " + coupons[i].getClass().getSimpleName() + ", 우선순위: " + coupons[i].priorityCheck());
        }
        System.out.println("--------------------------------");
    }
}
