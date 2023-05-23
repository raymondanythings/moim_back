package project.study.issue_tracker.core.study.adapter.`in`

import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import project.study.issue_tracker.common.annotation.business.authentication.LoginUser
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.common.login.GithubUser
import project.study.issue_tracker.core.study.adapter.`in`.request.StudyCreateRequest
import project.study.issue_tracker.core.study.adapter.`in`.response.StudyCreateResponse
import project.study.issue_tracker.core.study.application.port.`in`.StudyCreateUseCase
import project.study.issue_tracker.core.study.domain.Study
import java.time.Instant

@PresentationLayer
@RequestMapping("/api/study")
class StudyCreateAPI(
    private val studyCreateUseCase: StudyCreateUseCase
) {

    @PostMapping
    fun createStudy(
        @LoginUser githubUser: GithubUser,
        @RequestBody request: StudyCreateRequest
    ): ResponseEntity<StudyCreateResponse> {
        val newStudy = createNewStudy(githubUser, request)
        val studyId = studyCreateUseCase.createStudy(newStudy, request.hashtags)
        return ResponseEntity.status(CREATED)
            .body(StudyCreateResponse.of(studyId))
    }

    private fun createNewStudy(
        githubUser: GithubUser,
        request: StudyCreateRequest
    ): Study {
        return Study.createStudy(
            githubUser.getUserId(),
            request.placeId,
            request.title,
            request.content,
            request.xPosition,
            request.yPosition,
            request.participationFeeType,
            Instant.now()
        )
    }
}
