package TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
    @Test
    public void test1(){
        System.out.println("First Test");
        //Assert equals method take two parameter, if these two parameters are equals to each other
        //your test will pass
        Assert.assertEquals("Mothers Day","Mothers Day");
        // In hard Assertion, once assert failed next line will not executed
        // it will throw the exception right away
        System.out.println("After Assertion");
    }
@Test
    public void test2(){
    System.out.println("Second Test");
  // it will take boolean condition. if boolean condition is true test will pass
  //otherwise test will fail
    Assert.assertTrue("Mothers day".startsWith("Mother"));

   // since it is will return  true , I will be able to see the sout output
    System.out.println("After second Assertion");
}
}
