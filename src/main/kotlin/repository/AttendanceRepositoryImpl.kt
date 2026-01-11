package repository
import domain.model.Attendance
import Repo.AttendanceRepository
import dataSource.EcoSystemDataSource
import domain.mappers.toDomain
class AttendanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : AttendanceRepository {
    override fun getAllAttendance(): List<Attendance> =
        dataSource.getAttendances().map { it.toDomain() }
    override fun getAttendanceByMenteeId(menteeId: String): Attendance? =
        getAllAttendance().find { it.menteeId == menteeId }
}
