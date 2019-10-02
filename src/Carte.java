public class Carte {
    private String titlu;
    private String autor;


    public String getTitlu(){
        return titlu;
    }

    public String getAutor() {
        return autor;
    }
    Carte(String titlu, String autor){
        this.titlu=titlu;
        this.autor=autor;
    }
}
