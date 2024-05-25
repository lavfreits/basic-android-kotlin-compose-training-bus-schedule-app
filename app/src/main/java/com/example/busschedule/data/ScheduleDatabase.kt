package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusSchedule::class], version = 1, exportSchema = false)
abstract class ScheduleDatabase : RoomDatabase() {

    abstract fun busScheduleDao(): Dao

    companion object {
        @Volatile
        private var Instance: ScheduleDatabase? = null
        fun getDatabase(context: Context): ScheduleDatabase {
            return Instance ?: synchronized(this) {
                return Room.databaseBuilder(
                    context,
                    ScheduleDatabase::class.java,
                    "schedule_database"
                ).createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }

            }
        }

    }

}