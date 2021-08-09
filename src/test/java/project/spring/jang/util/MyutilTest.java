package project.spring.jang.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyutilTest {
    @Mock
    Myutil myutil;

    @BeforeEach
    void setup (){
        MockitoAnnotations.initMocks(this);
        myutil = new Myutil();
    }
    @Test
    void now() {
        System.out.println(myutil.now());
    }
}