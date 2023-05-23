package project.study.issue_tracker.test.helper.fixture.user

import project.study.issue_tracker.common.login.GithubUser

class UserFixture {

    private constructor() {
        throw AssertionError("올바른 방식으로 생성자를 호출해주세요.")
    }

    companion object {
        fun createUser(): GithubUser {
            return GithubUser(1L)
        }
    }
}
