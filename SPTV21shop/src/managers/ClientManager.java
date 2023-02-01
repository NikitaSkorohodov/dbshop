/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enyity.Client;
import java.util.List;
import java.util.Scanner;
;
/**
 *
 * @author NikitaSkr
 */
public class ClientManager {
    
    private final Scanner scanner;
    
    public ClientManager() {
       scanner = new Scanner(System.in);
    }
    
   public Client createClient(){
        System.out.println("4. Добавить клиента");
        Client client = new Client();
        System.out.println("Введите имя клинта: ");
        client.setFirstname(scanner.nextLine());
        System.out.print("Введите фамилию клинта: ");
        client.setLastname(scanner.nextLine());
        System.out.print("Введите телефон клинта: ");
        client.setPhone(scanner.nextLine());
        System.out.print("Введите деньги клинта: ");
        client.setMony(scanner.nextInt());
        
        return client;
    }
   public void printListClients(List<Client> clients){
        for (int i = 0; i < clients.size(); i++) {
            System.out.printf("%d. %s %s. щет: %s%n"
                    ,i+1
                    ,clients.get(i).getFirstname()
                    ,clients.get(i).getLastname()                    
                    ,clients.get(i).getMony()
            );
        }
    }
  
   
   public void Refill(List<Client> clients) {
        
        System.out.println("Выберите покупателя для записи балланса");
        System.out.println("список покупателей");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i + 1);
            System.out.println(clients.get(i).getFirstname());
            System.out.println(clients.get(i).getLastname());
            System.out.println("номер телефона"+clients.get(i).getPhone());
        }
        System.out.print("Введите номер покупателя: ");
        int client = scanner.nextInt(); scanner.nextLine();
        System.out.print("Сколько денег желаете добавить на счет? : ");
        int addMoney = scanner.nextInt(); scanner.nextLine();
        int TotalMoney = clients.get(client - 1).getMony()+ addMoney;
        clients.get(client - 1).setMony(TotalMoney);
        System.out.println("Счет пополнен!");
        System.out.println("На счету : " + clients.get(client - 1).getMony());

    }

    public void Refill(Client[] clients) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
