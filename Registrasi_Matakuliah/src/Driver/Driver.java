/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import Controller.ControllerDataDosen;
import java.sql.SQLException;
import Database.Database;

/**^
 *
 * @author Nuzulul
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        new Controller.ControllerLogin();
    }
    
}
