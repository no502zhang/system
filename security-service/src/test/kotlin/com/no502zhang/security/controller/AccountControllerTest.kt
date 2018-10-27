package com.no502zhang.security.controller

import com.no502zhang.security.SecurityTestStarterApplication
import com.no502zhang.security.repository.AccountRepository
import com.no502zhang.user.client.UserFeignClient
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [SecurityTestStarterApplication::class])
@WebAppConfiguration
class AccountControllerTest {
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var accountController: AccountController

    @MockBean
    lateinit var accountRepository: AccountRepository

    @MockBean
    lateinit var userFeignClient: UserFeignClient

    @Before
    fun init() {
        mvc = MockMvcBuilders.standaloneSetup(accountController).build()
    }

    @Test
    fun testCreateAccount() {

    }
}