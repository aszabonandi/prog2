package javafxapplication2;

/**
 *
 * @author aszab
 */
public class Car {

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setPaintjob(int paintjob) {
        this.paintjob = paintjob;
    }

    public void setRust(int rust) {
        this.rust = rust;
    }

    public void setAngelEyes(boolean angelEyes) {
        this.angelEyes = angelEyes;
    }

    public int getCondition() {
        return condition;
    }

    public int getPaintjob() {
        return paintjob;
    }

    public int getRust() {
        return rust;
    }

    public boolean isAngelEyes() {
        return angelEyes;
    }
    int condition;
    int paintjob = 0;
    int rust = 0;
    boolean angelEyes = false;
    
    
private  int getCondition(int paintjob, int rust){
    condition = (paintjob + rust)/2;
    return condition;
}


}


