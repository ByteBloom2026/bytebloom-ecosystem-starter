package data.dataSource

import data.dataSource.model.*

interface EcoSystemDataSource {
    fun getMentees(): List<MenteeRow>
    fun getMenteeById(id: String): MenteeRow?
    fun getMenteesByTeamId(teamId: String): List<MenteeRow>
    fun getTeams(): List<TeamRow>
    fun getTeamById(teamId: String): TeamRow?
    fun getPerformances(): List<PerformanceRow>
    fun getPerformanceByMenteeId(menteeId: String): List<PerformanceRow>
    fun getProjects(): List<ProjectRow>
    fun getProjectByTeamId(teamId: String): ProjectRow?
    fun getAttendances(): List<AttendanceRow>
    fun getAttendanceByMenteeId(menteeId: String): AttendanceRow?
}