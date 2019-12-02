package org.frittenbude.day02

enum class Opcode{
    ADD, MULTIPLY
}

data class IntcodeFragment(val opcode: Opcode, val posA: Int, val posB: Int, val posResult: Int)

class IntcodeFragmentFactory{
    companion object {
        fun fromIntegers(integers: List<Int>) : IntcodeFragment{
            val opcode = if (integers[0] == 1) Opcode.ADD else Opcode.MULTIPLY
            val posA = integers[1]
            val posB = integers[2]
            val posResult = integers[3]
            return IntcodeFragment(opcode, posA, posB, posResult)
        }
    }
}