package domain.repositories

import data.net.TwitterDataSource

class TwitterRepository(private val twitter: TwitterDataSource) {

    fun getLastTweetOf(twitterUser: String) = twitter.getLastTweetOf(twitterUser)
}