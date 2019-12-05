package org.frittenbude.day04

import org.junit.Test

class PasswordBruteForceTest {

    @Test
    fun solveQuizB(){
        val result = PasswordBruteForce().countPossibleSolutions(382345, 843167)
        print(result)
    }
}