package domain.model.exception


sealed class SearchTeamException : Throwable() {
    class EmptyTeamNameException: SearchTeamException()

    class InvalidTeamNameLengthException: SearchTeamException()
}

class EmptyMenteeNameException: Exception()

class NotCapitalizedNameException: Exception()