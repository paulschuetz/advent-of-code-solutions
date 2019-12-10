package org.frittenbude

import org.frittenbude.day08.ImageDecoder
import org.junit.Test
import java.io.File

class ImageDecoderTest{
    @Test
    fun test(){
        val pixels = File("src/test/resources/input08.txt").readText().toCharArray().map { Integer.parseInt(it.toString()) }.toList()
        print(ImageDecoder().checkForCorruption(pixels))
    }
}