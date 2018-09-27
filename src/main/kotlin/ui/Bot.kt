package ui

import domain.models.ConnectionSate
import domain.models.Event
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.slf4j.LoggerFactory
import ui.commands.*

object Bot {

    private val logger = LoggerFactory.getLogger(Bot::class.java)
    private lateinit var dependencies: DependencyTree

    private val serverDisposables = mutableMapOf<Long, Disposable>()
    private val listenEventDisposables = CompositeDisposable()

    @JvmStatic fun main(args: Array<String>) {
        dependencies = DependencyTree(args[0])

        listenServerConnection()
        listenMessages()
    }

    private fun listenServerConnection() {
        dependencies.listenServerConnection
                .execute()
                .subscribe(
                        {
                            when(it.state) {
                                is ConnectionSate.Unavailable -> disposeEventListener(it.serverId)
                            }
                        },
                        { logger.debug("Discord api error", it) })
    }

    private fun listenMessages() {
        dependencies.listenMessages
                .execute()
                .subscribe(
                        { processEvent(it) },
                        { logger.debug("Discord api error", it) })
    }

    private fun disposeEventListener(serverId: Long) {
        serverDisposables[serverId]?.run {
            serverDisposables.remove(serverId)
            listenEventDisposables.delete(this)
        }
    }

    private fun processEvent(it: Event) {
        when {
            it.message.startsWith(Info.START_KEYWORD, true)
            -> dependencies.info.processEvent(it)
        }
    }
}