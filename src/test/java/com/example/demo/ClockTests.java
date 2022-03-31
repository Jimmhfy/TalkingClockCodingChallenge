package com.example.demo;

import com.example.demo.Model.Clock;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ClockTests{
    @Test
    public void documentExampleOneOClock(){
        String validInput = "1:00";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("One o'clock");
    }

    @Test
    public void documentExampleTwoOClock(){
        String validInput = "2:00";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Two o'clock");
    }

    @Test
    public void documentExampleOneOClockOnThirteen(){
        String validInput = "13:00";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("One o'clock");
    }

    @Test
    public void documentExampleFivePastOne(){
        String validInput = "13:05";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Five past one");
    }

    @Test
    public void documentExampleTenPastOne(){
        String validInput = "13:10";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Ten past one");
    }

    @Test
    public void documentExampleTwentyFivePastOne(){
        String validInput = "13:25";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Twenty five past one");
    }

    @Test
    public void documentExampleHalfPastOne(){
        String validInput = "13:30";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Half past one");
    }

    @Test
    public void documentExampleTwentyFiveToTwo(){
        String validInput = "13:35";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Twenty five to two");
    }

    @Test
    public void documentExampleFiveToTwo(){
        String validInput = "13:55";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Five to two");
    }

    @Test
    public void documentExampleHalfPastFour(){
        String validInput = "16:30";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Half past four");
    }

    @Test
    public void documentExampleThreeOClockOnFifteen(){
        String validInput = "15:00";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Three o'clock");
    }

    @Test
    public void quarterToOnePassOnCovertTime(){
        String validInput = "12:45";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Quarter to one");
    }

    @Test
    public void quarterPastOnePassOnCovertTime(){
        String validInput = "1:15";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("Quarter past one");
    }

    @Test
    public void extremeCasePassOnCovertTime(){
        String validInput = "23:59";
        Clock clock = new Clock(validInput);
        assertThat(clock.toString()).isEqualTo("One to twelve");
    }

    @Test
    public void valuePassOnInputValidation(){
        String validInput = "15:30";
        boolean validationResult = Clock.validate(validInput);
        assertThat(validationResult).isEqualTo(true);
    }

    @Test
    public void valueFailOnInputValidation(){
        String invalidInput = "1530";
        boolean validationResult = Clock.validate(invalidInput);
        assertThat(validationResult).isEqualTo(false);
    }

    @Test
    public void characterValueFailOnInputValidation(){
        String invalidInput = "aa:bb";
        boolean validationResult = Clock.validate(invalidInput);
        assertThat(validationResult).isEqualTo(false);
    }

    @Test
    public void extremeCasePassOnInputValidation(){
        String validInput = "0:00";
        boolean validationResult = Clock.validate(validInput);
        assertThat(validationResult).isEqualTo(true);
    }

    @Test
    public void extremeCaseFailOnInputValidation(){
        String validInput = "0:0";
        boolean validationResult = Clock.validate(validInput);
        assertThat(validationResult).isEqualTo(false);
    }
}
