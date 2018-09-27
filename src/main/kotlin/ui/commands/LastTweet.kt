package ui.commands

import domain.models.Event
import domain.usecases.GetTwitterTimeline
import domain.usecases.SendMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LastTweet(sendMessage: SendMessage, private val getTwitterTimeline: GetTwitterTimeline) : Command(sendMessage) {

    companion object {
        const val START_KEYWORD = "b!lastTweet"
        const val ERROR_RESPONSE = "An error happened trying to get the last tweet"
    }

    override fun getLogger(): Logger = LoggerFactory.getLogger(LastTweet::class.java)

    override fun processEvent(event: Event) {
        val twitterUser = event.message.substring(START_KEYWORD.length, event.message.length).trim()

        getTwitterTimeline.execute(twitterUser).subscribe({
            sendResponse(event.channel, it.last().text)
        }, {
            sendResponse(event.channel, ERROR_RESPONSE)
        })
    }
}