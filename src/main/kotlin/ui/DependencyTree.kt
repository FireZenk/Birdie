package ui

import data.db.JsondbDataSource
import data.net.DiscordDataSource
import domain.repositories.DiscordRepository
import domain.usecases.*
import ui.commands.*

class DependencyTree(private val discordToken: String) {

    private val repository: DiscordRepository by lazy {
        DiscordRepository(DiscordDataSource(discordToken), JsondbDataSource())
    }

    val listenMessages: ListenMessages by lazy { ListenMessages(repository) }
    val listenServerConnection by lazy { ListenServerConnection(repository) }

    private val sendMessage: SendMessage by lazy { SendMessage(repository) }

    // Commands
    val info: Info by lazy { Info(sendMessage) }
}