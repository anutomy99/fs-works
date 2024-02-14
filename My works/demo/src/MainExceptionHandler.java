public class MainExceptionHandler {
    public static void main(String[] args) {
        try {
            String str = null;
            str.length();
//            int[] i ={1,2};
//            int number = i[3];
        } catch (NullPointerException e) {
            System.out.println("Matched NullPointerException");
            e.printStackTrace();
        }
        finally {
            System.out.println("Always execute ");
        }


    }
}
