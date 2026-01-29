import Repository.MenteeRepository
import java.io.File
import data.dataSource.CsvEcosystemDataSource
import domain.usecase.*
import repository.*

fun main() {
    val csvDataSource = CsvEcosystemDataSource(
        File("src/main/resources/mentees.csv"),
        File("src/main/resources/teams.csv"),
        File("src/main/resources/performance.csv"),
        File("src/main/resources/projects.csv"),
        File("src/main/resources/attendance.csv")
    )
    val menteeRepository = MenteeRepositoryImpl(csvDataSource)
    val teamRepositpry = TeamRepositoryImpl(csvDataSource)
    val performanceRepository = PerformanceRepositoryImpl(csvDataSource)
    val projectRepository = ProjectRepositoryImpl(csvDataSource)
    val attendanceRepository = AttendanceRepositoryImpl(csvDataSource)

    // execute the function  GetMenteeNameById
    val GetMenteeNameById = getMenteeNameById(menteeRepository)
    println("please entre the id mentee : " + GetMenteeNameById)

    // execute the function  getMenteeNamesByTeamName
    val GetMenteeNamesByTeamName = getMenteeNamesByTeamName(teamRepositpry, menteeRepository)
    println("please entre the team name : " + GetMenteeNamesByTeamName)

    // execute the function getNumberOfProjectsByMenteeId
    val GetNumberOfProjectsByMenteeId = getNumberOfProjectsByMenteeId(menteeRepository, projectRepository)
    println("please entre the id mentee" + GetNumberOfProjectsByMenteeId)

    //execute the function getTeamByMenteeName
    val GetTeamByMenteeName=getTeamByMenteeName(teamRepositpry,menteeRepository)
    println("please the entre the mentee name : "+GetTeamByMenteeName)

    //execute the function IsMenteeInTeam
    val IsMenteeInTeam = IsMenteeInTeam(teamRepositpry,menteeRepository)
    println("please enter the id mentee and team name"+IsMenteeInTeam)

    //execute the function GenerateTeamAttendanceReport
    val generateTeamAttendanceReport =GenerateTeamAttendanceReport(attendanceRepository,menteeRepository)
    println("please entre the teamid : "+generateTeamAttendanceReport)

   // execute the function  GetAverageAttendancePercentagePerTeam
   val getAverageAttendancePercentagePerTeam=GetAverageAttendancePercentagePerTeam(teamRepositpry,menteeRepository,attendanceRepository)
    println("the average attendanc : "+getAverageAttendancePercentagePerTeam)

    //execute the function GetMostAbsentMentees
    val getMostAbsentMentees=GetMostAbsentMentees(menteeRepository,attendanceRepository)
    println(getMostAbsentMentees)

    //execute the function GetPerfectAttendanceMentees
    val getPerfectAttendanceMentees=GetPerfectAttendanceMentees(attendanceRepository,menteeRepository)
    println("The perfect mentees : "+getPerfectAttendanceMentees)

    //execute the function GetPoorAttendanceMentees
    val getPoorAttendanceMentees=GetPoorAttendanceMentees(attendanceRepository,menteeRepository)
    println("The poor mentees : "+getPoorAttendanceMentees)

   //execute the function  getAverageScorePerSubmissionTypeUseCasel
    val GetAverageScorePerSubmissionTypeUseCasel=getAverageScorePerSubmissionTypeUseCase(performanceRepository)
    println(GetAverageScorePerSubmissionTypeUseCasel)

    //execute the function getMenteePerformanceBreakdown
    val GetMenteePerformanceBreakdown=getMenteePerformanceBreakdown(performanceRepository)
    println("plesae entre the ib mentee : "+GetMenteePerformanceBreakdown)


    //execute the function getMenteesWithLowAverageScoreUseCase
   val GetMenteesWithLowAverageScoreUseCase=getMenteesWithLowAverageScoreUseCase(menteeRepository,performanceRepository)
   println(GetMenteesWithLowAverageScoreUseCase)

    //execute the function getTeamAverageScore
    val GetTeamAverageScore=getTeamAverageScore(menteeRepository,performanceRepository)
    println("please entre the id team : "+GetTeamAverageScore)

    //execute the function getTopScoringMentee
    val GetTopScoringMentee=getTopScoringMentee(menteeRepository,performanceRepository)
    println("The top scor"+GetTopScoringMentee)
}//