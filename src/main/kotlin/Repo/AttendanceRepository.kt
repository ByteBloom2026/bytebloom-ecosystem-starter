package Repo

import domain.model.attendance


interface AttendanceRepository {
    fun getAllAttendance(): List<attendance>
    fun getAttendanceByMenteeId(menteeId: String):attendance?

}