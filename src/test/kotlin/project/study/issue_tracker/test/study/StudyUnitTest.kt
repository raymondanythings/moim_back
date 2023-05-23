package project.study.issue_tracker.test.study

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import project.study.issue_tracker.test.study.StudyFixture.Companion.createStudy

class StudyUnitTest {

    @Test
    @DisplayName("스터디가 존재할 때 장소를 등록할 수 있다.")
    fun when_study_exist_then_can_regist_place_id() {
        val study = createStudy()

        study.registerPlaceId(1L)

        assertEquals(1L, study.getPlaceId())
    }
}
