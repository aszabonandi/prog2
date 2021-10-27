package javafxapplication2;

/**
 *
 * @author aszab
 */
public class Character {
    
            //OsztálySzintű Vátozók
    String name = "";
    int money = 1000000;
    int happiness = 50;
    int cars = 0;
    int respect = 0;
    int friends = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public void setRespect(int respect) {
        this.respect = respect;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public int getMoney() {
        return money;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getCars() {
        return cars;
    }

    public int getRespect() {
        return respect;
    }

    public int getFriends() {
        return friends;
    }

}
