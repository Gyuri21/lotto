import java.util.Vector;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class LottoController {

    private ConnectDatabase connDb;
    private Vector<Integer> numberList;
    private Vector<Integer> drawedList;
    private Vector<Integer> choosenList;
    private Lottoform lottoFrm;
    private int counter = 0;

    public LottoController(ConnectDatabase connDb){
        choosenList = new Vector<>();
        drawedList = new Vector<>();
        numberList = new Vector<>();
        this.connDb = connDb;
        lottoFrm = new Lottoform();
        lottoFrm.exitBtn.addActionListener(event -> exit());
        lottoFrm.drwaBtn.addActionListener(event -> drawing());
        fillNumberList();
        numbercheckBoxes();
        lottoFrm.setVisible(true);
    }
    private void fillNumberList(){
        for(int i = 1; i < 91; i++  ){
            numberList.add(i);
        }
    }
    private void numbercheckBoxes(){
        
        for(Integer i = 1; i < 91; i++ ){
            JCheckBox box = new JCheckBox();
            box.setText(i.toString());
            lottoFrm.centerPnl.add(box);

            box.addItemListener(event -> {
                JCheckBox check = (JCheckBox) event.getSource();
                choosenList.add(Integer.parseInt(check.getText()));
                counter ++;
                if(counter == 5){
                    lottoFrm.drwaBtn.setEnabled(true);
                }else{
                    lottoFrm.drwaBtn.setEnabled(false);
                }
            });
        }
    }
    private void drawing(){
        int numbers = 90;
        Random rand = new Random();

        for(int i = 0; i < 5; i++){
            int number = rand.nextInt(numbers) + 1;
            numberList.remove(number - 1);
            numbers --;
            drawedList.add(number);
        }
        showResult();
        numberstoDatabase();
    }
    private void showResult(){
        Integer result = 0;
        for(int i = 0;i < choosenList.size(); i++){
            for(int j = 0; j < drawedList.size(); j++){
                if(choosenList.get(i) == drawedList.get(j)){
                    result ++;
                }
            }
        }
        String resultValue = lottoFrm.resultLbl.getText();
        lottoFrm.resultLbl.setText(resultValue + result.toString());

        
        for(int i = 0;i < drawedList.size(); i++){
            String drawValue = lottoFrm.drawLbl.getText();
            String number = String.valueOf(drawedList.get(i));
            lottoFrm.drawLbl.setText(drawValue + number + " ");
        }
    }
    private void numberstoDatabase(){
        Connection conn = connDb.getConnection();
        Statement stmt = null;
        String sqlData = "";
        for(int i = 0; i < drawedList.size(); i++){
            if(i < (drawedList.size() - 1)){
                sqlData += String.valueOf(drawedList.get(i)) + ":";
            }else{
                sqlData += String.valueOf(drawedList.get(i));
            }
        }
        System.out.println(sqlData);
        String sql = "INSERT INTO drawed(draw) VALUES ('"+ sqlData +"');";
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void exit(){
        System.exit(0);
    }
    
}
