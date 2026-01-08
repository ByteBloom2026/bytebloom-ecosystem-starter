package repository

import Repo.AttendanceRepository
import dataSource.CsvEcosystemDatasource
import dataSource.EcoSystemDataSource
import domain.model.attendance

class AttendanceRepositoryImpl (
    private val attendanceDataSource: EcoSystemDataSource
): AttendanceRepository {
    override fun getAllAttendance(): List<attendance> {
        return attendanceDataSource.getattendance().map { row
            ->
            attendance(
                menteeId = row.menteeId,
                week_1 = row.week_1,
                week_2 = row.week_2,
                week_3 = row.week_3)
        }
    }

    override fun getAttendanceByMenteeId(menteeId: String): attendance? {
       return getAllAttendance().find { it.menteeId == menteeId }
    }

}