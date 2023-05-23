package project.study.issue_tracker.common.configuration.argumentresolver

import org.springframework.stereotype.Component
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import project.study.issue_tracker.common.argumentresolver.LoginUserArgumentResolver

@Component
class WebMvcConfiguration(
    private val loginUserArgumentResolver: LoginUserArgumentResolver
) : WebMvcConfigurer {

    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        resolvers.add(loginUserArgumentResolver)
    }
}
