import christmas.model.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("배지 테스트")
class BadgeTest {

    @Test
    @DisplayName("혜택이 없는 경우 None 배지를 반환해야 함")
    void calculateBadge_NoBenefits_ReturnsNoneBadge() {
        int totalBenefits = 0;
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("없음", badgeName);
    }

    @ParameterizedTest
    @ValueSource(ints = {4000, 3000 ,2000, 1000})
    @DisplayName("혜택이 별 기준 미만인 경우 None 배지를 반환해야 함")
    void calculateBadge_LessThanStarThreshold_ReturnsNoneBadge(int totalBenefits) {
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("없음", badgeName);
    }

    @ParameterizedTest
    @ValueSource(ints = {5000, 8000, 9000})
    @DisplayName("혜택이 별 기준 이상인 경우 별 배지를 반환해야 함")
    void calculateBadge_StarThreshold_ReturnsStarBadge(int totalBenefits) {
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("별", badgeName);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 17000})
    @DisplayName("혜택이 트리 기준 이상인 경우 트리 배지를 반환해야 함")
    void calculateBadge_TreeThreshold_ReturnsTreeBadge(int totalBenefits) {
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("트리", badgeName);
    }

    @ParameterizedTest
    @ValueSource(ints = {20000, 25000, 30000})
    @DisplayName("혜택이 산타 기준 이상인 경우 산타 배지를 반환해야 함")
    void calculateBadge_AboveSantaThreshold_ReturnsSantaBadge(int totalBenefits) {
        String badgeName = Badge.calculateBadge(totalBenefits);
        assertEquals("산타", badgeName);
    }
}
