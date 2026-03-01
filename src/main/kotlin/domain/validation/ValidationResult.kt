package domain.validation

import domain.model.Attendance
import domain.model.Mentee
import domain.model.PerformanceSubmission
import domain.model.Project
import domain.model.Team


sealed class ValidationResult<out T> {
    data class Success<T>(val data: T) : ValidationResult<T>()
    data class Failure(val errors: List<ValidationError>) : ValidationResult<Nothing>()
    companion object {
        fun <T> success(data: T): ValidationResult<T> = Success(data)
        fun failure(field: String, message: String): Failure =
            Failure(listOf(ValidationError(field, message)))
    }
}