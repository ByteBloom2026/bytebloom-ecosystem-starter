import java.io.File





fun main() {
    println("ByteBloom Academy: Ecosystem Project Starter")
    val theNewMenteess = parseMenteeRaw()
    if (theNewMentees!= null) {
        println("totel menteess : {${theNewMenteess .size}}")
    } else {
        println("no  find data on mentees file")
    }
    val theNewPerformances  = parsePerformanceRaw()
    if (theNewPerformance!= null) {
        println("totel preformances : {${theNewPerformances.size}}")
    } else {
        println("no  find data on predormance file")
    }
    val parsedTeams = parseTeamData()
    if (parsedTeams!= null) {
        println("Total teams parsed : ${parsedTeams.size}")
    } else {
        println("No team data available for parsing .")
    }
}
