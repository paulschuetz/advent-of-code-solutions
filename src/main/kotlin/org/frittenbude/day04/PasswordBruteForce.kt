package org.frittenbude.day04

class PasswordBruteForce{
    // start and end inclusive
    fun countPossibleSolutions(start: Int, end: Int) : Int{
        return IntRange(start, end).count { checkNumber(it) }
    }

    /**
     * Returns TRUE if number is a valid password and false if not
     */
    fun checkNumber(number: Int) : Boolean{
        val nums = number.toString().toCharArray()
        var hasDouble = false
        for(index in 0 until nums.size-1){
            if(nums[index] > nums[index+1]) return false
            if(nums[index] == nums[index+1]) {
                // check if left or right sight is also same number -> not a pair but at least triple!
                // if index is 0 only check right side
                if(index == 0){
                    if(nums[2] != nums[1]) hasDouble = true
                }
                // if index is far right just check left side
                else if(index == nums.size-2){
                    if(nums[nums.size-2] != nums[nums.size-3]) hasDouble = true
                }
                // else check both sides
                else{
                    if(nums[index] != nums[index-1] && nums[index] != nums[index+2]) hasDouble = true
                }
            }
        }
        return hasDouble
    }
}