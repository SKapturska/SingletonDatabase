package singletondatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonDatabase {

    public static void main(String[] args) {
       menu();
        
        
    }
    
    static void menu(){
        SingletonConnection singletonConnection = SingletonConnection.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.print("1: wyświetlanie tablicy \n2: aktualizacja tablicy\n");
        int choice = sc.nextInt();
        
        if(choice == 1){ 
            try {
            ResultSet rs = singletonConnection.executeQuery("Select * from person");
            while(rs.next()){
            System.out.println("id: " + rs.getString(1));
            System.out.println("nazwisko: " + rs.getString(2));
            System.out.println("imie: " + rs.getString(3));
            System.out.println("miasto: " + rs.getString(4));
            System.out.println("nr telefonu: " + rs.getString(5));
            System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        }else if(choice == 2){
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Podaj komendę SQL: ");
            //sc.next();
            String query = sc2.nextLine();
            System.out.println(singletonConnection.executeUpdate(query));
        }
    }
    
}
