package mission.couponDiscount;

public interface Coupon {
    boolean isAvailableApply(int price);

    int priorityCheck();

    int discountPrice(int price);
}
