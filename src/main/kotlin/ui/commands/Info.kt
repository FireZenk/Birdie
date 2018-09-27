package ui.commands

import domain.models.Event
import domain.usecases.SendMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Info(sendMessage: SendMessage) : Command(sendMessage) {

    companion object {
        const val START_KEYWORD = "b!info"
        const val END_RESPONSE =
                "Here is the list of all available commands:\n\n" +
                "Configuration:\n" +
                "   **TODO**\n" +
                "Usage:\n" +
                "   **TODO**"
    }

    override fun getLogger(): Logger = LoggerFactory.getLogger(Info::class.java)

    override fun processEvent(event: Event) = sendResponse(event.channel, END_RESPONSE)
}