package domain.model

import org.apache.tools.ant.Project
import org.gradle.internal.serialize.codecs.core.NodeOwner


data class  Team(
    val teamId: String,
    val teamName: String,
    val mentorLead: String,
    //val mentees: List<Mentee>,
     val project: Project?=null
)