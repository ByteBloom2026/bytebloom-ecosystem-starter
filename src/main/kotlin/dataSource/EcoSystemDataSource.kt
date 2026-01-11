package dataSource
import dataSource.model.MenteeRow
import dataSource.model.TeamRow
import dataSource.model.PerformanceRow
import dataSource.model.ProjectRow
import dataSource.model.AttendanceRow
interface EcoSystemDataSource {
    fun getMentees(): List<MenteeRow>?
    fun getTeams(): List<TeamRow>
    fun getPerformances(): List<PerformanceRow>
    fun getProjects():List<ProjectRow>
    fun getAttendances(): List<AttendanceRow>
}