package mission.couponDiscount;

public class SaleCoupon implements Coupon {
    @Override
    public boolean isAvailableApply(int price) {
        return price >= 5000;
    }

    @Override
    public int priorityCheck() {
        return 2;
    }

    @Override
    public int discountPrice(int price) {
        return price / 10;
    }
}
