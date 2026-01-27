import java.io.File
import data.dataSource.CsvEcosystemDataSource
import domain.model.Mentee
import domain.model.Team
import domain.usecase.getMenteeNamesByTeamName
import domain.usecase.getTeamByMenteeName
import repository.*
fun main() {
    val csvDataSource = CsvEcosystemDataSource(
        File("src/main/resources/mentees.csv"),
        File("src/main/resources/teams.csv"),
        File("src/main/resources/performance.csv"),
        File("src/main/resources/projects.csv"),
        File("src/main/resources/attendance.csv")
    )
    val menteeRepo = MenteeRepositoryImpl(csvDataSource)
    val teamRepo = TeamRepositoryImpl(csvDataSource)
    val performanceRepo = PerformanceRepositoryImpl(csvDataSource)
    val projectRepo = ProjectRepositoryImpl(csvDataSource)
    val attendanceRepo = AttendanceRepositoryImpl(csvDataSource)
    val allMentees = menteeRepo.getAllMentees()
    val allTeams = teamRepo.getAllTeams()

    // call a function getMenteesNamesByTeamName
   val GetMenteeNamesByTeamName= getMenteeNamesByTeamName(allMentees,allTeams)
   val nameMentees=GetMenteeNamesByTeamName.execute("Alpha")
   println( "the nameTeam : "+nameMentees)

   // call a function getTeamByMenteeName
    val GetTeamByMenteeName= getTeamByMenteeName(allMentees,allTeams)
    val nameTeam=GetTeamByMenteeName.execute(" Mateo Gibson")
    println( "the nameTeam : "+nameTeam)




}