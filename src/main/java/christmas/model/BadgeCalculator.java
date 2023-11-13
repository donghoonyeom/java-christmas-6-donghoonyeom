package christmas.model;

public class BadgeCalculator {
    private static final int STAR_BADGE = 5000;
    private static final int TREE_BADGE = 10000;
    private static final int SANTA_BADGE = 20000;
    private static final String NO_BADGE_MESSAGE = "없음";


    public static String calculateBadge(int totalBenefits) {
        if (totalBenefits >= SANTA_BADGE) {
            return "산타";
        }
        if (totalBenefits >= TREE_BADGE) {
            return "트리";
        }
        if (totalBenefits >= STAR_BADGE) {
            return "스타";
        }
        return NO_BADGE_MESSAGE;
    }
}
