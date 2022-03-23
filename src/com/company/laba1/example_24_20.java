public class example_24_20 {
    public static double hyp(double a, double b){
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static void main(String[] args) {
        double a = 10.0, b = 4.0;

        System.out.println("katet a=" + a);
        System.out.println("katet b=" + b);
        System.out.println("hypotenuse с=" + hyp(a, b));
    }
}
