package com.adaptionsoft.games.uglytrivia

import org.assertj.core.api.Assertions.assertThat
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
}