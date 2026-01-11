package domain.mappers
import dataSource.model.AttendanceRow
import domain.model.Attendance
fun AttendanceRow.toDomain(): Attendance =
    Attendance(
        menteeId, listOf(week_1, week_2, week_3)
    )
