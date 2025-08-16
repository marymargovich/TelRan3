public class TestRecur {
    public static void main(String[] args) {
        System.out.println(factorialSimple(5));
        System.out.println(factorialSimple(14));
        System.out.println(factorialSimple(15));
        System.out.println(factorialSimple(20));


    }
    public static long factorialSimple( int n){
        //5! = 1*2*3*4*5
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public static long factorialSimpleRecursion( int n){
        if( n<=1)
            return 1;
        return n*(factorialSimpleRecursion(n-1));
    }


}
