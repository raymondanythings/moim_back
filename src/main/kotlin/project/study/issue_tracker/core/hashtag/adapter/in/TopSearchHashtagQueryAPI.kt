package project.study.issue_tracker.core.hashtag.adapter.`in`

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/top-searched-hashtag")
class TopSearchHashtagQueryAPI(private val hashtagQueryService: HashtagQueryService) {

    @GetMapping
    fun searchTopSearchedHashtag(): ResponseEntity<HashtagsResponse> {
        val data = hashtagQueryService.findAll()
        return ResponseEntity.ok(HashtagsResponse(data))
    }
}
