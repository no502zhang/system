package com.no502zhang.log.controller

import com.no502zhang.log.LogTestStarterApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [LogTestStarterApplication::class])
@WebAppConfiguration
class OperationControllerTest {
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var operationController: OperationController

    @Before
    fun init() {
        mvc = MockMvcBuilders.standaloneSetup(operationController).build()
    }


    @Test
    fun testCreate() {

    }

    @Test
    fun testDelete() {

    }

    @Test
    fun testUpdate() {

    }

    @Test
    fun testGet() {

    }

    @Test
    fun testList() {

    }
}