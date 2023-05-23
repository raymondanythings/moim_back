package project.study.issue_tracker.core.study.adapter.`in`

import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import project.study.issue_tracker.common.annotation.business.authentication.LoginUser
import project.study.issue_tracker.common.annotation.helper.layer.PresentationLayer
import project.study.issue_tracker.common.login.GithubUser

@PresentationLayer
@RequestMapping("/api/study")
class StudyDeleteAPI(private val studyDeleteUseCase: StudyDeleteUseCase) {

    @DeleteMapping("/{studyId}")
    fun deleteStudy(
        @LoginUser githubUser: GithubUser,
        @PathVariable studyId: Long
    ): ResponseEntity<Unit> {
        studyDeleteUseCase.deleteStudy(githubUser, studyId)
        return ResponseEntity.status(NO_CONTENT)
            .build()
    }
}
