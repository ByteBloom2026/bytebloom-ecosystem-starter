package model

import domain.Mentee

data class TeamRaw(
    val teamId: String,
    val teamName: String,
    val mentorLead: String
)

