package data.repository.mappers
import data.datasource.model.AttendanceRow
import domain.model.Attendance
import domain.model.AttendanceState
fun AttendanceRow.toDomain(): Attendance =
    Attendance.create( menteeId = menteeId,
        weeks = weeks.split(",").map {
            when (it.trim().uppercase()) {
                "PRESENT" -> AttendanceState.PRESENT
                "LATE" -> AttendanceState.LATE
                else -> AttendanceState.ABSENT
            }
        }
    )
