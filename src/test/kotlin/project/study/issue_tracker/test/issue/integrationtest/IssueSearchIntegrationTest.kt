package project.study.issue_tracker.test.issue.integrationtest

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import project.study.issue_tracker.common.configuration.IntegrationTestBase
import project.study.issue_tracker.core.issue.application.port.`in`.CreateIssueUsecase
import project.study.issue_tracker.core.issue.application.port.`in`.SearchIssueUseCase
import project.study.issue_tracker.test.helper.fixture.issue.IssueFixture.Companion.createIssue
import project.study.issue_tracker.test.helper.fixture.user.UserFixture.Companion.createUser

@DisplayName("[IntegrationTest] 이슈 조회 통합 테스트")
class IssueSearchIntegrationTest : IntegrationTestBase() {

    @Autowired
    private lateinit var createIssueUseCase: CreateIssueUsecase

    @Autowired
    private lateinit var searchIssueUseCase: SearchIssueUseCase

    @Test
    @DisplayName("이슈가 존재하면 아이디로 조회할 수 있다.")
    fun when_issue_exist_then_can_find_by_id() {
        val issue = createIssueUseCase.createIssue(createUser(), createIssue())

        assertNotNull(searchIssueUseCase.findIssueById(issue.getIssueId()!!))
    }
}
