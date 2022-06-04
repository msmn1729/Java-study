package mission.couponDiscount;

import java.time.LocalDate;

public class DateCoupon implements Coupon {
    private LocalDate expiredDate;

    public DateCoupon(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String getName() {
        return "DateCoupon";
    }

    @Override
    public boolean isAvailableApply(int price) {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.compareTo(expiredDate) > 0) {
            System.out.println("유효기간이 만료된 쿠폰입니다.");
            return false;
        }
        if (price < 3000) {
            System.out.println("3,000원 미만인 상품에는 적용할 수 없습니다.");
            return false;
        }
        return true;
    }

    @Override
    public int priorityCheck() {
        return 3;
    }

    @Override
    public int discountPrice(int price) {
        if (3000 <= price && price <= 5000) {
            return 3000;
        } else if (price > 5000) {
            return 1000;
        }
        return -1;
    }
}
