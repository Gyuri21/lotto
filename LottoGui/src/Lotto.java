import java.sql.Connection;

public class Lotto {
    public static void main(String[] args) throws Exception {
        ConnectDatabase connDb = new ConnectDatabase();
        LottoController lottoCtr = new LottoController(connDb);

    }
}
