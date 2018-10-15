package com.no502zhang.starter

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [StarterApplication::class])
@WebAppConfiguration
class StarterApplicationTests {

    @Test
    fun contextLoads() {
        println("test")
    }

}
