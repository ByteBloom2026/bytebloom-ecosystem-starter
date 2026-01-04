package Repo

import domain.model.projects


interface projectsRepository {
    fun getAllProject(): List<projects>
    fun getProjectByTeamId(teamId:String): projects?
}