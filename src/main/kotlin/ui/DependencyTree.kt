package ui

import data.db.JsondbDataSource
import data.net.DiscordDataSource
import data.net.TwitterDataSource
import domain.repositories.DiscordRepository
import domain.repositories.TwitterRepository
import domain.usecases.*
import twitter4j.TwitterFactory
import ui.commands.*

class DependencyTree(private val discordToken: String) {

    /* region Discord */
    private val discordRepository: DiscordRepository by lazy {
        DiscordRepository(DiscordDataSource(discordToken), JsondbDataSource())
    }

    val listenMessages: ListenMessages by lazy { ListenMessages(discordRepository) }
    val listenServerConnection by lazy { ListenServerConnection(discordRepository) }
    /* endregion Discord */

    /* region Twitter */
    private val twitterRepository: TwitterRepository by lazy {
        TwitterRepository(TwitterDataSource(TwitterFactory.getSingleton()))
    }
    /* endregion Twitter */

    /* region private UseCases */
    private val sendMessage: SendMessage by lazy { SendMessage(discordRepository) }
    private val twitterTimeline: GetTwitterTimeline by lazy { GetTwitterTimeline(twitterRepository) }
    /* endregion private UseCases */

    // Commands
    val info: Info by lazy { Info(sendMessage) }
    val lastTweet: LastTweet by lazy { LastTweet(sendMessage, twitterTimeline) }
}