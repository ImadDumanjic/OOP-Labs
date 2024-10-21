package People;

class Person {
       private String name;
       private String address;
       private int age;
       private String country;

       Person(String name, String address){
           this.name = name;
           this.address = address;
       }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
           return this.name + "\n " + this.address;
       }

       public static void main(String[] args){
           Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
           Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
           System.out.println(pekka);
           System.out.println(esko);

       }
}







