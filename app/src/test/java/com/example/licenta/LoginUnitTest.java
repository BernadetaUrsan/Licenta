package com.example.licenta;

import android.content.Context;

import com.example.licenta.viewModels.LoginViewModel;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.example.licenta.AppConstants.LOGIN_SUCCES;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {
    @Mock
    LoginViewModel loginViewModel;
    @Mock
    FirebaseAuth mAuth;

    Context context;

    @Before
    public void setUp()
    {
        loginViewModel = new LoginViewModel();
//        mAuth = Mockito.mock(FirebaseAuth.class);
//        loginViewModel.setmAuth(mAuth);
    }

//    @Test
//    public void areInputsValid() {
//        boolean validEmail =  loginViewModel.validateEmail("berna@gmail.com");
//        assertEquals(true, validEmail);
//    }

//    @Test
//    public void isPasswordValid(){
//        boolean validPassword =  loginViewModel.validatePassword("berna");
//        assertEquals( true, validPassword);
//    }
//
//    @Test
//    public void checkLogin(){
//        String result = loginViewModel.onSignIn("berna@classboard.com","cosmin");
//        assertEquals(LOGIN_SUCCES, result);
//    }
}
