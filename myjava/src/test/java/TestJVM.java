import org.junit.Test;

public class TestJVM {
//    @Test
//    public void testStack(){
//        callSelf(1);
//    }
//
//    public void callSelf(int n ){
//        System.out.println(n);
//        n++;
//        callSelf(n);
//    }

    public static void main(String[] args) {
        int n = 1024 * 1024 * 6;
        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[n];
            System.out.println();
        }
    }

}
