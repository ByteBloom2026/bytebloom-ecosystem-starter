package domain.model
data class Team(
    val teamId: String,
    val teamName: String,
    val mentorLead: String,
    val project: Project?=null
)