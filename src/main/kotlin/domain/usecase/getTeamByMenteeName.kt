package domain.usecase
import Repository.MenteeRepository
import Repository.TeamRepository


class getTeamByMenteeName (
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
){
    operator fun invoke(menteeName: String): String? {
        val mentee = menteeRepository.getAllMentees()
            .find { it.name == menteeName }
        val team = teamRepository.getAllTeams()
            .find { it.teamId == mentee?.teamId }
        return team?.teamName
    }
}