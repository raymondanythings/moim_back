package project.study.issue_tracker.core.study.domain

enum class ParticipationFeeType {
    FREE,
    CHARGED;

    companion object {
        fun invoke(participationFeeType: String): ParticipationFeeType = when (participationFeeType) {
            "FREE" -> FREE
            "CHARGED" -> CHARGED
            else -> throw IllegalArgumentException("올바른 참가비 유형을 입력해주세요.")
        }
    }
}
