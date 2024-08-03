import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Random random = new Random();
    private List<Integer> mU;
    private List<Integer> mD;
    private Usuario usuario;
    private Usuario dealer;

    public Juego(Usuario usuario) {
        this.usuario = usuario;
        this.dealer = new Usuario("Dealer");
        this.mU = new ArrayList<>();
        this.mD = new ArrayList<>();
    }

    private int CR() {
        return random.nextInt(9) + 1;
    }

    public void StartGame() {
        mU.clear();
        mU.add(CR());
        mD.clear();
        mD.add(CR());
    }

    public void SacarCarta() {
        mU.add(CR());
        mD.add(CR());
    }

    private int Sum(List<Integer> mano) {
        int total = 0;
        for (int carta : mano) {
            total += carta;
        }
        return total;
    }

    public List<Integer> getManoUsuario() {
        return new ArrayList<>(mU);
    }

    public List<Integer> getManoDealer() {
        return new ArrayList<>(mD);
    }

    public int getValorManoUsuario() {
        return Sum(mU);
    }

    public int getValorManoDealer() {
        return Sum(mD);
    }
}
