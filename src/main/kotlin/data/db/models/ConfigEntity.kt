package data.db.models

import io.jsondb.annotation.Document
import io.jsondb.annotation.Id

@Document(collection = "config", schemaVersion = "1.0")
class ConfigEntity {

    @Id val id: Long = 0L
    lateinit var postingChannel: String

    companion object {
        private const val POSTING_CHANNEL_DEFAULT = "general"

        fun default(): ConfigEntity = ConfigEntity().apply {
            postingChannel = POSTING_CHANNEL_DEFAULT
        }
    }
}