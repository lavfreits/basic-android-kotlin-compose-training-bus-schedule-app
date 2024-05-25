package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.ScheduleDatabase

class BusScheduleApplication : Application() {
    val database by lazy { ScheduleDatabase.getDatabase(this) }
}