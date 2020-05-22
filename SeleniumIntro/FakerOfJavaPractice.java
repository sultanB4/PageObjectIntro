package SeleniumIntro;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class FakerOfJavaPractice {

    public static void main(String[] args) {
        Faker adress = new Faker();
       String a = adress.name().lastName().toString();
       String fam = adress.name().firstName().toString();

        System.out.println(a +" " +fam);

    }
}
