package repository
import domain.model.Attendance
import Repository.AttendanceRepository
import data.dataSource.EcoSystemDataSource
import repository.mappers.toDomain
class AttendanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : AttendanceRepository {
    override fun getAllAttendance(): List<Attendance> =
        dataSource.getAttendances().map { it.toDomain() }
    override fun getAttendanceByMenteeId(menteeId: String): Attendance? =
        dataSource.getAttendanceByMenteeId(menteeId)?.toDomain()
}