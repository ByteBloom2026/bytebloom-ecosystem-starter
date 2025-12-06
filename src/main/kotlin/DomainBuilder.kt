//val rawTeams = parseTeamData()
//val rawMentees = parseMenteeRaw()
//val rawSubmissions = parsePerformanceRaw()

import model.PerformanceRaw
import model.TeamRaw
import model.MenteeRaw
import domain.Team
import domain.Mentee
import domain.PerformanceSubmission

class DomainBuilder {

    fun buildDomainGraph(
        rawTeams: List<TeamRaw>, rawMentees: List<MenteeRaw>,
        rawSubmissions: List<PerformanceRaw>): List<Team> {

        val teamsById = rawTeams.associateBy({ it.teamId})
        { teamRaw ->
            Team(teamRaw.teamName)
        }

//        val menteesById = mutableMapOf<String, Mentee>()
//        for (rawMentee in rawMentees) {
//            val team = teamsById.values.firstOrNull {
//                it.teamName.contains(rawMentee.teamId, ignoreCase = true)
//            }

//            val mentee = Mentee(
//                menteeName = rawMentee.name,
//                menteeId = rawMentee.menteeId,
//                team = team)
//            menteesById[rawMentee.menteeId] = mentee
//        }

//        for (rawSubmission in rawSubmissions) {
//            val mentee = menteesById[rawSubmission.menteeId]
//        }

        return teamsById.values.toList()
    }
}//