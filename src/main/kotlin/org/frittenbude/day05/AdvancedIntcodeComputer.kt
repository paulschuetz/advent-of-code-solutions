package org.frittenbude.day05

class AdvancedIntcodeComputer{
    fun compute(inputCodes: List<Int>){
        val input = inputCodes.toMutableList()

        var index = 0
        while (true){
            if(input[index] == 99){
                println("reached end!")
                return
            }
            when(input[index] % 10){
                1 -> {
                    // val pMode3 = (input[index] / 10000) % 10
                    val pMode2 = (input[index] / 1000) % 10
                    val pMode1 = (input[index] / 100) % 10
                    val summand1 = if(pMode1 == 0) input[input[index+1]] else input[index+1]
                    val summand2 = if(pMode2 == 0) input[input[index+2]] else input[index+2]
                    input[input[index+3]] = summand1 + summand2
                    index +=4
                }
                2 -> {
                    // val pMode3 = (input[index] / 10000) % 10
                    val pMode2 = (input[index] / 1000) % 10
                    val pMode1 = (input[index] / 100) % 10
                    val factor1 = if(pMode1 == 0) input[input[index+1]] else input[index+1]
                    val factor2 = if(pMode2 == 0) input[input[index+2]] else input[index+2]
                    //val writeIndex = if(pMode3 == 0) input[input[index+3]]
                    input[input[index+3]] = factor1 * factor2
                    index+=4
                }
                3 -> {
                    input[input[index+1]] = 5
                    index+=2
                }
                4 -> {
                    val pMode1 = (input[index] / 100) % 10
                    val outputIndex = if(pMode1 == 0) input[index+1] else index +1
                    println("output: ${input[outputIndex]}")
                    index +=2
                }
                5 -> {
                    val pMode2 = (input[index] / 1000) % 10
                    val pMode1 = (input[index] / 100) % 10
                    val number = if(pMode1 == 0) input[input[index+1]] else input[index+1]
                    if(number != 0){
                        index = if(pMode2 == 0) input[input[index+2]] else input[index+2]
                    }
                    else{
                        index += 3
                    }
                }
                6 -> {
                    val pMode2 = (input[index] / 1000) % 10
                    val pMode1 = (input[index] / 100) % 10
                    val number = if(pMode1 == 0) input[input[index+1]] else input[index+1]
                    if(number == 0){
                        index = if(pMode2 == 0) input[input[index+2]] else input[index+2]
                    }else{
                        index += 3
                    }
                }
                7 -> {
                    val pMode2 = (input[index] / 1000) % 10
                    val pMode1 = (input[index] / 100) % 10
                    val num1 = if(pMode1 == 0) input[input[index+1]] else input[index+1]
                    val num2 = if(pMode2 == 0) input[input[index+2]] else input[index+2]
                    val saveIndex = input[index+3]
                    input[saveIndex] = if(num1 < num2) 1 else 0
                    index +=4
                }
                8 -> {
                    val pMode2 = (input[index] / 1000) % 10
                    val pMode1 = (input[index] / 100) % 10
                    val num1 = if(pMode1 == 0) input[input[index+1]] else input[index+1]
                    val num2 = if(pMode2 == 0) input[input[index+2]] else input[index+2]
                    val saveIndex = input[index+3]
                    input[saveIndex] = if(num1 == num2) 1 else 0
                    index +=4
                }
                else -> throw Exception("Unknown operation")
            }
        }
    }
}