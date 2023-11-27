package christmas.model;

public enum Badge {
    SANTA(20000, "산타"),
    TREE(10000, "트리"),
    STAR(5000, "별"),
    NONE(0, "없음");

    private final int threshold;
    private final String name;

    Badge(int threshold, String name) {
        this.threshold = threshold;
        this.name = name;
    }

    public static String calculateBadge(int totalBenefits) {
        Badge badge = findApplicableBadge(totalBenefits);
        return badge.name;
    }

    private static Badge findApplicableBadge(int totalBenefits) {
        for (Badge badge : values()) {
            if (totalBenefits >= badge.threshold) {
                return badge;
            }
        }
        return NONE;
    }

    public String getName() {
        return name;
    }
}
