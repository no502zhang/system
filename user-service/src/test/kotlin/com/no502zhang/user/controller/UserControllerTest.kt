package com.no502zhang.user.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.no502zhang.security.client.AccountFeignClient
import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.security.dto.CreateAccountResult
import com.no502zhang.user.UserTestStarterApplication
import com.no502zhang.user.domain.User
import com.no502zhang.user.dto.CreateUserParam
import com.no502zhang.user.repository.UserRepository
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [UserTestStarterApplication::class])
@WebAppConfiguration
class UserControllerTest {
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var userController: UserController

    @MockBean
    lateinit var accountFeignClient: AccountFeignClient

    @MockBean
    lateinit var userRepository: UserRepository

    @Before
    fun init() {
        mvc = MockMvcBuilders.standaloneSetup(userController).build()
        Mockito.`when`(accountFeignClient.create(CreateAccountParam("ownerId", "account", "password"))).thenReturn(CreateAccountResult("id", "account"))
    }

    @Test
    fun testCreate() {
        val param = CreateUserParam("account", "password", "name", "remark")
        var user = User(param.name, param.remark)
        Mockito.`when`(userRepository.save(user)).thenReturn(user)
        Mockito.`when`(accountFeignClient.create(CreateAccountParam(user.id, param.account, param.password))).thenReturn(CreateAccountResult(UUID.randomUUID().toString().replace("-", ""), param.account))


        val request = MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON_UTF8).content(ObjectMapper().writeValueAsString(param))
        val result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk).andReturn()

        assertEquals(result.response.status, 200)

        println(result.response.contentAsString)
    }
}