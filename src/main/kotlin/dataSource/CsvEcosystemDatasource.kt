package dataSource
import dataSource.model.*
import java.io.File
class CsvEcosystemDataSource(
    menteeFile: String,
    teamFile: String,
    performanceFile: String,
    projectFile: String,
    attendanceFile: String
) : EcoSystemDataSource {
    private val menteeLines = File(menteeFile).readLines().drop(1)
    private val teamLines = File(teamFile).readLines().drop(1)
    private val performanceLines = File(performanceFile).readLines().drop(1)
    private val projectLines = File(projectFile).readLines().drop(1)
    private val attendanceLines = File(attendanceFile).readLines().drop(1)
    override fun getMentees(): List<MenteeRow> = menteeLines.map {
        val parts = it.split(",")
        MenteeRow(parts[0].trim(), parts[1].trim(), parts[2].trim())
    }
    override fun getTeams(): List<TeamRow> = teamLines.map {
        val parts = it.split(",")
        TeamRow(parts[0].trim(), parts[1].trim(), parts[2].trim())
    }
    override fun getPerformances(): List<PerformanceRow> = performanceLines.map {
        val parts = it.split(",")
        PerformanceRow(parts[0].trim(), parts[1].trim(),
            parts[2].trim(),
            parts[3].trim()
        )
    }
    override fun getProjects(): List<ProjectRow> = projectLines.map {
        val parts = it.split(",")
        ProjectRow(parts[0].trim(), parts[1].trim(), parts[2].trim())
    }
    override fun getAttendances(): List<AttendanceRow> = attendanceLines.map {
        val parts = it.split(",")
        AttendanceRow(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim())
    }
}