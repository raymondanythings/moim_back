package project.study.issue_tracker.test.study

import project.study.issue_tracker.core.common.field.Deleted
import project.study.issue_tracker.core.study.domain.ParticipationFeeType
import project.study.issue_tracker.core.study.domain.Study
import project.study.issue_tracker.core.study.domain.StudyStatus
import java.time.Instant

class StudyFixture {

    companion object {
        fun createStudy(): Study {
            return Study.of(
                1L,
                1L,
                null,
                "낙성대 스터디모아점에서 토익 스터디 하실 분 구해요.",
                "현재 5명 있고 고득점 목표로 하고 있습니다. 연락주세요.",
                3.555555,
                3.1423142414,
                ParticipationFeeType.FREE,
                10,
                0,
                StudyStatus.RECRUITING,
                Instant.now(),
                Instant.now(),
                Deleted.FALSE,
            )
        }
    }
}
