import java.io.File
import dataSource.CsvEcosystemDataSource
import repository.*
import domain.EcosystemService
fun main() {
    val csvDataSource = CsvEcosystemDataSource(
        "src/main/resources/mentees.csv",
        "src/main/resources/teams.csv",
        "src/main/resources/performance.csv",
        "src/main/resources/project.csv",
        "src/main/resources/attendance.csv"
    )
    val menteeRepo = MenteeRepositoryImpl(csvDataSource)
    val teamRepo = TeamRepositoryImpl(csvDataSource)
    val performanceRepo = PerformanceRepositoryImpl(csvDataSource)
    val projectRepo = ProjectRepositoryImpl(csvDataSource)
    val attendanceRepo = AttendanceRepositoryImpl(csvDataSource)
    val ecosystemService = EcosystemService(
        teamRepo,
        menteeRepo,
        performanceRepo,
        projectRepo,
        attendanceRepo
    )
    ecosystemService.findTeamsWithNoProject().forEach { println(it) }
    println(ecosystemService.findProjectAssignedToTeam("team1"))
    println(ecosystemService.findLeadMentorForMentee("m001"))
    println(ecosystemService.getOverallPerformanceAverageForTeam("team1"))
    println(ecosystemService.findTopScoringMenteeOverall())
    println(ecosystemService.getPerformanceBreakdownForMentee("m001"))
    ecosystemService.findMenteesWithPerfectAttendance().forEach { println(it) }
    ecosystemService.flagMenteesWithPoorAttendance(2).forEach { println(it) }
    println(ecosystemService.generateTeamAttendanceReport("team1"))

}