package service;

public class FeatureFlagService {

    public static final String REQUEST_URL = "http://javadevmatt.pythonanywhere.com/tutorialclicker/api/v1.0/features";
    public static final String FEATURE_SHOP = "FEATURE_SHOP";

    private boolean shop = false;

    public void makeFeatureFlagService() {
        // TODO
    }

    public boolean hasShop() {
        return shop;
    }

    public void setShop(boolean shop) {
        this.shop = shop;
    }
}
