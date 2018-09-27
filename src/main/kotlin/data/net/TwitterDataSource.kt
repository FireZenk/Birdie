package data.net

import io.reactivex.Single
import twitter4j.Status
import twitter4j.Twitter

class TwitterDataSource(private val twitter: Twitter) {

    fun something(): Single<List<Status>> = Single.just(
            twitter.timelines().getUserTimeline("JYPETWICE").map { it }.toList()
    )
}