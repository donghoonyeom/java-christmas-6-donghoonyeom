package christmas.model;

public enum Badge {
    STAR(5000, "스타"),
    TREE(10000, "트리"),
    SANTA(20000, "산타"),
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
        for (Badge badge : Badge.values()) {
            if (totalBenefits >= badge.threshold) {
                return badge;
            }
        }
        return Badge.NONE;
    }

    public String getName() {
        return name;
    }
}
