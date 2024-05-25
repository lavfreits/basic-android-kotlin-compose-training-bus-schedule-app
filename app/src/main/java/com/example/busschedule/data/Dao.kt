package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * from BusSchedule WHERE stop_name = :stopName ORDER BY arrival_time ASC ")
    fun getScheduleByStopName(stopName: String): Flow<List<BusSchedule>>

    @Query("SELECT * from BusSchedule ORDER BY arrival_time ASC")
    fun getAllItems(): Flow<List<BusSchedule>>
}