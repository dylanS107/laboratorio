package P1Eva1SosaDylan;

public class Estudiante {
	private String Name;
    private int Age;
    private String Sex;
    private double[] Ratings;

    public Estudiante(String Name, int Age, String Sex, double[] Ratings) {
        this.Name = Name;
        this.Age = Age;
        this.Sex = Sex;
        this.Ratings = Ratings;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public double[] getRatings() {
        return Ratings;
    }

    public void setCalificacioRatings(double[] Ratings) {
        this.Ratings = Ratings;
    }

public double calcularPromedio() {
        double suma = 0;
        for (double Ratings : Ratings) {
            suma = suma + Ratings;
        }
        return suma / Ratings.length;
}

}