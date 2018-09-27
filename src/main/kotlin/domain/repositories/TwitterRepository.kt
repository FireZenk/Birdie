package domain.repositories

import data.net.TwitterDataSource

class TwitterRepository(private val twitter: TwitterDataSource) {

    fun getTwiceTimeline() = twitter.something()
}