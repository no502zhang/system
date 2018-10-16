package com.no502zhang.user.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.no502zhang.security.client.AccountFeignClient
import com.no502zhang.security.dto.CreateAccountParam
import com.no502zhang.security.dto.CreateAccountResult
import com.no502zhang.user.UserTestStarterApplication
import com.no502zhang.user.domain.User
import com.no502zhang.user.dto.CreateUserParam
import com.no502zhang.user.dto.ListUserParam
import com.no502zhang.user.dto.UpdateUserParam
import com.no502zhang.user.repository.UserRepository
import com.no502zhang.user.vo.UserType
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
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
    }

    @Test
    fun testCreate() {
        val param = CreateUserParam("account", "password", "name", "remark")
        val user = User(param.name, param.remark)
        Mockito.`when`(userRepository.save(user)).thenReturn(user)
        Mockito.`when`(accountFeignClient.create(CreateAccountParam(ownerId = user.id, account = param.account, password = param.password)))
                .thenReturn(CreateAccountResult(UUID.randomUUID().toString().replace("-", ""), param.account))

        val request = MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON_UTF8).content(ObjectMapper().writeValueAsString(param))
        val result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk).andReturn()

        assertEquals(result.response.status, 200)

        println(result.response.contentAsString)
    }

    @Test
    fun testDelete() {
        val id = "deleteuserid"

        val request = MockMvcRequestBuilders.delete("/users/$id")
        mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun testUpdate() {
        val id = "updateuserid"
        val param = UpdateUserParam("name", "remark")
        val user = User(id, UserType.PERSONAL, param.name ?: "name", param.remark)
        Mockito.`when`(userRepository.findById(id)).thenReturn(Optional.of(user))
        Mockito.`when`(userRepository.save(user)).thenReturn(user)

        val request = MockMvcRequestBuilders.put("/users/$id").contentType(MediaType.APPLICATION_JSON_UTF8).content(ObjectMapper().writeValueAsString(param))
        val result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk).andReturn()

        assertEquals(result.response.status, 200)

        println(result.response.contentAsString)
    }

    @Test
    fun testGet() {
        val id = "getuserid"
        val user = User(id, UserType.PERSONAL, "name", "remark")
        Mockito.`when`(userRepository.findById(id)).thenReturn(Optional.of(user))

        val request = MockMvcRequestBuilders.get("/users/$id")
        val result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk).andReturn()

        assertEquals(result.response.status, 200)

        println(result.response.contentAsString)
    }

    @Test
    fun testList() {
        val param = ListUserParam(pageNum = 1, pageSize = 10)
        val pageRequest = PageRequest.of(param.pageNum, param.pageSize)
        val total = 100L
        val userList = mutableListOf<User>()
        for (i in 1..10) {
            userList.add(User("name$i", "remark$i"))
        }
        Mockito.`when`(userRepository.findAll(pageRequest)).thenReturn(PageImpl(userList, pageRequest, total))

        val request = MockMvcRequestBuilders.get("/users/")
        val result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk).andReturn()

        assertEquals(result.response.status, 200)

        println(result.response.contentAsString)
    }
}