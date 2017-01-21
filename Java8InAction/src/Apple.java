/**
 * Created by Vladimir on 11-Jan-17.
 */
public class Apple {
    private String color;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavy(Apple apple) {
        return apple.getWeight() > 50;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    private Integer weight;

    public String toString(){
        return "color: "+this.color+", weight: "+this.weight;
    }

}
