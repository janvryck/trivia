package com.adaptionsoft.games.uglytrivia

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `Can initialize Game`() {
        val game = Game()

        assertThat(game).isNotNull
        with(game) {
            assertThat(popQuestions).containsExactly(
                *(0..49).map { "Pop Question $it" }.toTypedArray()
            )
            assertThat(scienceQuestions).containsExactly(
                *(0..49).map { "Science Question $it" }.toTypedArray()
            )
            assertThat(sportsQuestions).containsExactly(
                *(0..49).map { "Sports Question $it" }.toTypedArray()
            )
            assertThat(rockQuestions).containsExactly(
                *(0..49).map { "Rock Question $it" }.toTypedArray()
            )
        }
    }

    @Test
    fun `Add a player`() {
        val game = Game()

        val playerName = "player"
        val actual = game.add(playerName)

        assertThat(actual).isTrue()
        with(game) {
            assertThat(players).containsExactly(playerName)
            assertThat(places[0]).isEqualTo(0)
            assertThat(purses[0]).isEqualTo(0)
            assertThat(inPenaltyBox[0]).isFalse()
        }
    }

    @Test
    fun `Has at most 6 players`() {
        val game = Game()

        val thrown = catchThrowable {
            repeat(7) { playerNumber ->
                game.add("player-$playerNumber")
            }
        }

        assertThat(thrown).isInstanceOfSatisfying(ArrayIndexOutOfBoundsException::class.java) {
            assertThat(it).hasMessage("Index 6 out of bounds for length 6")
        }
    }
}