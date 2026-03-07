package domain.validation

interface Validator<T> {
    fun validate(data: T): ValidationResult<T>
}

interface EcosystemValidator<T>{
    fun validate(data: T): Result<T>
}