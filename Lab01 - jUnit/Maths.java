import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Maths {

    private final String name;
    private final int age;
    private int[] array1;
    private int[] array2;

    public Maths(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int add(int... a) {
        return Arrays.stream(a).sum();
    }

    public static int sub(int all, int... subs) {
        return all - Arrays.stream(subs).sum();
    }

    public static int mult(int... mults) {
        return Arrays.stream(mults).reduce(1, Math::multiplyExact);
    }

    public static int div(int dividor, int divider) {
        return (int) (dividor / divider);
    }

    public static boolean mixBoolean(int iterations) {
        int i = iterations % 2 == 0 ? iterations : 0;
        boolean b = iterations % 4 == 0;
        while (i < iterations) {
            b = !b;
            i++;
        }
        return b;
    }

    public static int[] sort(int[] array){
        Arrays.sort(array);
        return array;
    }

    public void exceptionThrower() throws IOException {
        BufferedImage bd = javax.imageio.ImageIO.read(new java.io.File("nonexistant.png"));
        if(bd == null){
            throw new IOException("Image is null");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int[] getArray1() {
        return array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }
}
