import christmas.model.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Badge 테스트")
class BadgeTest {

    @Test
    @DisplayName("혜택이 없는 경우 None 배지를 반환해야 함")
    void calculateBadge_NoBenefits_ReturnsNoneBadge() {
        int totalBenefits = 0;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("없음", badgeName);
    }

    @Test
    @DisplayName("혜택이 별 기준 미만인 경우 None 배지를 반환해야 함")
    void calculateBadge_LessThanStarThreshold_ReturnsNoneBadge() {
        int totalBenefits = 4000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("없음", badgeName);
    }

    @Test
    @DisplayName("혜택이 별 기준인 경우 별 배지를 반환해야 함")
    void calculateBadge_StarThreshold_ReturnsStarBadge() {
        int totalBenefits = 5000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("별", badgeName);
    }

    @Test
    @DisplayName("혜택이 별 기준과 트리 기준 사이인 경우 별 배지를 반환해야 함")
    void calculateBadge_BetweenStarAndTreeThreshold_ReturnsStarBadge() {
        int totalBenefits = 8000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("별", badgeName);
    }

    @Test
    @DisplayName("혜택이 트리 기준인 경우 트리 배지를 반환해야 함")
    void calculateBadge_TreeThreshold_ReturnsTreeBadge() {
        int totalBenefits = 10000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("트리", badgeName);
    }

    @Test
    @DisplayName("혜택이 트리 기준과 그 이상인 경우 트리 배지를 반환해야 함")
    void calculateBadge_BetweenTreeAndSantaThreshold_ReturnsSantaBadge() {
        int totalBenefits = 15000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("트리", badgeName);
    }

    @Test
    @DisplayName("혜택이 산타 기준인 경우 산타 배지를 반환해야 함")
    void calculateBadge_SantaThreshold_ReturnsSantaBadge() {
        int totalBenefits = 20000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("산타", badgeName);
    }

    @Test
    @DisplayName("혜택이 산타 기준을 초과한 경우 산타 배지를 반환해야 함")
    void calculateBadge_AboveSantaThreshold_ReturnsSantaBadge() {
        int totalBenefits = 25000;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("산타", badgeName);
    }
}
