package domain.usecases

import domain.repositories.TwitterRepository

class GetTwitterTimeline(private val repository: TwitterRepository) {

    fun execute() = repository.getTwiceTimeline()
}