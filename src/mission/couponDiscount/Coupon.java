package mission.couponDiscount;

public interface Coupon {
    String getName();
    boolean isAvailableApply(int price);

    int priorityCheck();

    int discountPrice(int price);
}
