package project.study.issue_tracker.common.login

class GithubUser(private val userId: Long) {

    fun getUserId(): Long {
        return userId
    }

    override fun toString(): String {
        return userId.toString()
    }
}
