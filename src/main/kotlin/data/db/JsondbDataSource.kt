package data.db

import data.db.models.ConfigEntity
import io.jsondb.JsonDBTemplate
import io.reactivex.Completable
import java.io.File
import java.time.LocalDate

class JsondbDataSource {

    companion object {
        private val CONFIG_COLLECTION = ConfigEntity::class.java
        private const val DATABASE_LOCATION = "database"
        private const val DATABASE_PACKAGE = "data.db.models"
    }

    private fun getConfig(db: JsonDBTemplate): ConfigEntity = db.getCollection(CONFIG_COLLECTION).firstOrNull()
            ?: ConfigEntity.default()

    private fun checkCollection(serverId: Long, collection: Class<*>): JsonDBTemplate {
        checkDirectory(serverId)

        val db = JsonDBTemplate("$DATABASE_LOCATION/$serverId", DATABASE_PACKAGE)
        if (db.collectionExists(collection).not()) {
            db.createCollection(collection)
        }
        return db
    }

    private fun checkDirectory(serverId: Long) {
        val directory = File("$DATABASE_LOCATION/$serverId")
        if (directory.exists().not()) {
            directory.mkdir()
        }
    }
}