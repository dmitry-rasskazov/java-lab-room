public class example_24_18 {
    static double a =10.0, b=4.0, c;

    public static double hyp(){
        return c = Math.sqrt(pow(a, 2) + pow(b, 2));
    }

    public static double pow(double number, double degree) {
        return Math.exp(degree * Math.log(number));
    }

    public static void main(String[] args) {
        System.out.println("katet a=" + a);
        System.out.println("katet b=" + b);
        System.out.println("hypotenuse с=" + hyp());
    }
}
