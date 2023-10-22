package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class GameNumbersTest {
    @Test
    fun `생성실패_입력이 null임`() {
        assertThrows<IllegalArgumentException> { GameNumbers(null) }
    }

    @Test
    fun `생성실패_문자열의 길이가 3이 아님`() {
        assertAll(
            { assertThrows<IllegalArgumentException> { GameNumbers("1") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("23") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("4567") } },
        )
    }

    @Test
    fun `생성실패_중복되는 문자가 존재함`() {
        assertAll(
            { assertThrows<IllegalArgumentException> { GameNumbers("111") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("223") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("455") } },
        )
    }

    @Test
    fun 생성성공() {
        assertAll(
            { assertDoesNotThrow { GameNumbers("123") } },
            { assertDoesNotThrow { GameNumbers("456") } },
            { assertDoesNotThrow { GameNumbers("789") } },
        )
    }
}