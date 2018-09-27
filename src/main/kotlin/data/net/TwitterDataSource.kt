package data.net

import io.reactivex.Single
import twitter4j.Status
import twitter4j.Twitter

class TwitterDataSource(private val twitter: Twitter) {

    fun getLastTweetOf(screenName: String): Single<List<Status>> = Single.just(
            twitter.timelines().getUserTimeline(screenName).map { it }.toList()
    )
}