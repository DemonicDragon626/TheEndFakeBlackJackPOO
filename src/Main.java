import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombreUsuario = sc.next();
        Usuario usuario = new Usuario(nombreUsuario);

        while (true) {
            System.out.println("Que accion desea realizar? : " +
                    "\n1. Comenzar una partida de BlackJack" +
                    "\n2. Revisar estadistica de Victorias/Perdidas" +
                    "\n3. Salir" +
                    "\n ");
            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Juego juego = new Juego(usuario);
                    juego.StartGame();
                    juego.SacarCarta();

                    int jugar = 0;
                    while (jugar != 2 && juego.getValorManoUsuario() < 22) {
                        System.out.println("Tu mano: " + juego.getManoUsuario() + " Total: " + juego.getValorManoUsuario());
                        System.out.println("Mano del dealer: " + juego.getManoDealer() + " Total: " + juego.getValorManoDealer());
                        System.out.println("Que desea hacer?" +
                                "\n1. Sacar otra carta" +
                                "\n2. Terminar partida");
                        jugar = sc.nextInt();
                        if (jugar == 1) {
                            juego.SacarCarta();
                        }
                    }

                    int valorUsuario = juego.getValorManoUsuario();
                    int valorDealer = juego.getValorManoDealer();

                    if (valorUsuario > 21) {
                        System.out.println("Has perdido");
                        usuario.setLose(usuario.getLose() + 1);
                    } else if (valorDealer > 21) {
                        System.out.println("Has ganado");
                        usuario.setWins(usuario.getWins() + 1);
                    } else if (valorUsuario > valorDealer) {
                        System.out.println("Has ganado");
                        usuario.setWins(usuario.getWins() + 1);
                    } else if (valorUsuario < valorDealer) {
                        System.out.println("Has perdido");
                        usuario.setLose(usuario.getLose() + 1);
                    } else {
                        System.out.println("Han empatado");
                        usuario.setTie(usuario.getTie() + 1);
                    }
                    break;

                case 2:
                    System.out.println("**************************************************"
                            + "\nEstadisticas del Usuario: "
                            + "\nNombre: " + usuario.getNombUs()
                            + "\nVictorias: " + usuario.getWins()
                            + "\nPerdidas: " + usuario.getLose()
                            + "\nEmpate: " + usuario.getTie()
                            + "\n***************************************************");
                    break;

                case 3:
                    sc.close();
                    return;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }
}
