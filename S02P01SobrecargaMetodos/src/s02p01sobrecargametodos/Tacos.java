package s02p01sobrecargametodos;

public class Tacos {
    public String Carne;
    public String Tortilla;
    public String Salsa;
    public String Cebolla;
    public String[] Condimentos;

    public Tacos(){
        this.Carne = "";
        this.Tortilla = "";
        this.Salsa = "";
        this.Cebolla = "";
        this.Condimentos = new String[0];
    }
    
    public Tacos(String Carne, String Tortilla){
        this.Carne = Carne;
        this.Tortilla = Tortilla;
    }

    public Tacos(String Carne, String Tortilla, String Salsa){
        this.Carne = Carne;
        this.Tortilla = Tortilla;
        this.Salsa = Salsa;
    }

    public Tacos(String Carne, String Tortilla, String Salsa, String Cebolla){
        this.Carne = Carne;
        this.Tortilla = Tortilla;
        this.Salsa = Salsa;
        this.Cebolla = Cebolla;
    }

    public Tacos(String Carne, String Tortilla, String Salsa, String Cebolla, String[] Condimentos){
        this.Carne = Carne;
        this.Tortilla = Tortilla;
        this.Salsa = Salsa;
        this.Cebolla = Cebolla;
        this.Condimentos = Condimentos;
    }
}