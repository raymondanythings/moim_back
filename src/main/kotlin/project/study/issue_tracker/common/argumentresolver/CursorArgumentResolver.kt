package project.study.issue_tracker.common.argumentresolver

import project.study.issue_tracker.common.annotation.business.paging.CursorPageable
import project.study.issue_tracker.core.common.Cursor
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class CursorArgumentResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(CursorPageable::class.java)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Cursor {
        val index = webRequest.getParameter("index")?.let { parseLong(it) }
        val pageSize = webRequest.getParameter("pageSize")?.let { parseInt(it) }
        return Cursor(index, pageSize)
    }

    fun parseInt(value: String): Int {
        return value.toInt()
    }

    fun parseLong(value: String): Long {
        return value.toLong();
    }
}
