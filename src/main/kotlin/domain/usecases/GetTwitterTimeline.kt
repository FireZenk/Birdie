package domain.usecases

import domain.repositories.TwitterRepository

class GetTwitterTimeline(private val repository: TwitterRepository) {

    fun execute(twitterUser: String) = repository.getLastTweetOf(twitterUser)
}