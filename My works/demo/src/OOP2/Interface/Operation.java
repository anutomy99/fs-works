package OOP2.Interface;

public interface Operation {
    public int perform(int x, int y);
}
class Add implements Operation{

    @Override
    public int perform(int x, int y) {
        return  x+y;
    }
}
class Main{
    public static void main(String[] args) {
        Operation o = new Add();
        System.out.println(o.perform(8,2));
    }

}
