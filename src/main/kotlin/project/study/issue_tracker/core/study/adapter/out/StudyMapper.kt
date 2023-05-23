package project.study.issue_tracker.core.study.adapter.out

import org.locationtech.jts.geom.Point
import org.locationtech.jts.io.WKTReader
import org.springframework.stereotype.Component
import project.study.issue_tracker.core.study.domain.Study
import java.math.BigDecimal

@Component
class StudyMapper {

    fun mapToDomainEntity(studyJpaEntity: StudyJpaEntity): Study {
        return Study.of(
            studyJpaEntity.getUserId(),
            studyJpaEntity.getStudyId()!!,
            studyJpaEntity.getPlaceId(),
            studyJpaEntity.getTitle(),
            studyJpaEntity.getContent(),
            studyJpaEntity.getXPosition(),
            studyJpaEntity.getYPosition(),
            studyJpaEntity.getParticipationFeeType(),
            studyJpaEntity.getCurrentStudyMemberCount(),
            studyJpaEntity.getStudyStatus(),
            studyJpaEntity.getCreatedAt(),
            studyJpaEntity.getLastModifiedAt(),
            studyJpaEntity.getDeleted()
        )
    }

    fun mapToJpaEntity(study: Study): StudyJpaEntity {
        return StudyJpaEntity(
            study.getStudySeq(),
            study.getUserSeq(),
            study.getPlaceId(),
            study.getTitleAsValue(),
            study.getContentAsValue(),
            "1234",
            BigDecimal(10000),
            10,
            10,
            PointEntry(getPoint(study.getXPosition(), study.getYPosition())),
            study.getParticipationFeeType(),
            study.getCreatedAt()
        )
    }

    private fun getPoint(
        xPosition: Double,
        yPosition: Double
    ): Point {
        val pointWKT = "POINT($xPosition $yPosition)"
        try {
            val point = WKTReader().read(pointWKT)
            return point.interiorPoint
        } catch (exception: Exception) {
            throw IllegalArgumentException("올바른 값을 넣어주세요.")
        }
        throw IllegalArgumentException()
    }
}
