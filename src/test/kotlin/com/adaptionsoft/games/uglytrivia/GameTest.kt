package com.adaptionsoft.games.uglytrivia

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `Can create Game`() {
        assertThat(Game()).isNotNull
    }
}