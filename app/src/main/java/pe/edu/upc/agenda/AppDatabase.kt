package pe.edu.upc.agenda

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database_agenda"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}