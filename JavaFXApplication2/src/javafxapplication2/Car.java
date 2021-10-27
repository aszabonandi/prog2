package javafxapplication2;

/**
 *
 * @author aszab
 */
public class Car {
    int condition;
    int paintjob = 0;
    int rust = 0;
    boolean angelEyes = false;
    
    
private  int getCondition(int paintjob, int rust){
    condition = (paintjob + rust)/2;
    return condition;
}

}


