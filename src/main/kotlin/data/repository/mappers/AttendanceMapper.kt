package data.repository.mappers
import data.datasource.model.AttendanceRow
import domain.model.Attendance

fun AttendanceRow.toDomain(): Attendance =
    Attendance(
        menteeId, weeks,
        attendanceState = TODO()
    )
