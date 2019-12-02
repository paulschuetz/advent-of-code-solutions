package org.frittenbude.day02

class IntcodeComputer{

    fun compute(input: ArrayList<Int>) : ArrayList<Int>{
        // clone list to ensure immutability
        val integers = ArrayList(input)

        var index = 0
        while(integers.get(index) != 99){
            runFragment(IntcodeFragmentFactory.fromIntegers(integers.subList(index, index +4)), integers)
            index += 4
        }

        return integers
    }

    private fun runFragment(fragment: IntcodeFragment, integers: ArrayList<Int>){
        when(fragment.opcode){
            Opcode.ADD -> integers[fragment.posResult] = integers[fragment.posA] + integers[fragment.posB]
            Opcode.MULTIPLY -> integers[fragment.posResult] = integers[fragment.posA] * integers[fragment.posB]
        }
    }
}