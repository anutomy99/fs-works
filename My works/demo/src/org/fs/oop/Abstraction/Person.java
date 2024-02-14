package org.fs.oop.Abstraction;

public abstract class Person {
    public String getGender() {
        return gender;
    }

    public Person(String name,String gender) {
        this.gender = gender;
        this.name=name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String  gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public void changeName(String newName){
        System.out.println(name);
        System.out.println(newName);
        for(int j=10;j>=1;j++) {
            System.out.println("Current name: " + name);
            for (int i = 10; i >= 1; i--) {
                System.out.println("Duration " + i + " sec");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.name = newName;
            }

            if (newName.equals("Anu")) {
                newName= "Malu";

            } else {
                newName = "Anu";
            }

        }
        System.out.println("After changing :" + newName);
    }




    public  abstract  void office();
}
