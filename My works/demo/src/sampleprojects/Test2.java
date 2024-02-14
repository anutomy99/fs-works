package sampleprojects;

class Test1 {

}

class Test2 {
    Test2(){
        System.out.println("Constructor ");
    }                                                                                                                                                   
    {
       System.out.println("Static method of test2");
    }

    static {
        System.out.println("Welcome from static block" );
    }
    public static void main(String[] args)
    {
        {
            System.out.println("Hello");
        }
      Test2 t2 =new Test2();
    }

}
