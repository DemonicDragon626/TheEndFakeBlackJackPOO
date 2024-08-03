public class Usuario {
    private String NombUs;
    private int Wins;
    private int lose;
    private int tie;

    public Usuario(String nombUs) {
        this.NombUs = nombUs;
        this.Wins = 0;
        this.lose = 0;
        this.tie = 0;
    }

    public void setNombUs(String nombUs) {
        NombUs = nombUs;
    }

    public String getNombUs() {
        return NombUs;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getLose() {
        return lose;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getWins() {
        return Wins;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getTie() {
        return tie;
    }
    public void incrementarVictorias() {
        this.Wins++;
    }

    public void incrementarDerrotas() {
        this.lose++;
    }

    public void incrementarEmpates() {
        this.tie++;
    }

}
