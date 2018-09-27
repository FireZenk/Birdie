package domain.repositories

import data.db.JsondbDataSource
import data.net.DiscordDataSource
import domain.models.Event
import domain.models.ServerConnectionState
import io.reactivex.Completable
import io.reactivex.Flowable
import org.javacord.api.entity.channel.TextChannel
import java.time.LocalDate

class DiscordRepository(private val discord: DiscordDataSource,
                        private val database: JsondbDataSource) {

    fun listenConnection(): Flowable<ServerConnectionState> = discord.listenConnection()

    fun listenMessages(): Flowable<Event> = discord.listenMessages()

    fun sendMessage(channel: TextChannel, message: String): Completable = discord.sendMessage(channel, message)
}