package com.example.licenta;

import com.example.licenta.viewModels.LoginViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {
    @Mock
    LoginViewModel loginViewModel;

    @Before
    public void setUp()
    {
        loginViewModel = new LoginViewModel();
    }

    @Test
    public void areInputsValid() {
        boolean validEmail =  loginViewModel.validateEmail("berna@gmail.com");
        assertEquals(true, validEmail);
    }

    @Test
    public void isPasswordValid(){
        boolean validPassword =  loginViewModel.validatePassword("berna");
        assertEquals( true, validPassword);
    }
}
