package racingcar.validation

import java.lang.NumberFormatException

class CheckValidation {

    fun checkCarName(
        carName: String
    ) {
        require(
            checkNameLength(carName) &&
                    checkNameIsBlank(carName)
        ) {
            "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
        }
        require(
            checkEnglishRegex(carName) ||
                    checkKoreanRegex(carName)
        ) {
            "올바른 자동차 이름을 입력해야 합니다."
        }
    }

    fun checkInputRacingCount(
        userInput: String
    ) {
        require(
            checkIsnumber(userInput) &&
                    checkIsPositive(userInput.toInt())
        ) {
            "양의 정수를 입력해야 합니다."
        }
    }

    private fun checkIsnumber(
        userInput: String
    ): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkIsPositive(
        number: Int
    ): Boolean {
        return number >= 0
    }

    private fun checkNameLength(
        carName: String
    ): Boolean {
        return carName.length <= CAR_MAX_LENGTH
    }

    private fun checkNameIsBlank(
        carName: String
    ): Boolean {
        return carName.isNotBlank()
    }

    private fun checkEnglishRegex(
        carName: String
    ): Boolean {
        return carName.matches(CHECK_ENGLISH.toRegex())
    }

    private fun checkKoreanRegex(
        carName: String
    ): Boolean {
        return carName.matches(CHECK_KOREAN.toRegex())
    }

    companion object {
        private const val CAR_MAX_LENGTH = 5
        private const val CHECK_ENGLISH = "^[a-zA-Z]*\$"
        private const val CHECK_KOREAN = "^[가-힣]*\$"
    }
}