package data.repository
import data.EcoSystemDataSource
import domain.model.Attendance
import data.repository.mappers.toDomain

class AttendanceRepositoryImpl(
    private val dataSource: EcoSystemDataSource
) : AttendanceRepository {
    override fun getAllAttendance(): Result<List<Attendance>> {
        val resultFromData = dataSource.getAttendances()
        return resultFromData.map { list ->
            list.map { it.toDomain() }
        }
    }
    override fun getAttendanceByMenteeId(menteeId: String): Result<Attendance?> {
        return dataSource.getAttendanceByMenteeId(menteeId).map {
            it?.toDomain()
        }
    }
}


