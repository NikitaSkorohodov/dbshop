/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptv21shop;
import enyity.Client;
import enyity.Product;
import enyity.Purchase;
import java.util.Arrays;
import java.util.Scanner;
import managers.ClientManager;
import managers.HistoryManager;
import managers.ProductManager;
import managers.BaseDataManager;
import java.util.List;

/**
 *
 * @author NikitaSkr
 */
public class App {
    private final ProductManager productManager;
    private final ClientManager clientManager;
    private final HistoryManager historyManager;
    private final BaseDataManager dataManager;

    private List<Product> products;
    private List<Client> clients;
    private List<Purchase> histories;
 
    

    
    public App() {
        dataManager = new BaseDataManager();
        historyManager = new HistoryManager();
        clientManager=new ClientManager();
        productManager = new ProductManager();
        
        
        products=dataManager.loadProduct();
        clients=dataManager.loadClients();
        histories = dataManager.loadHistories();
        Purchase purchase = new Purchase();
    }
    
    
   public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
     
        do{
            System.out.println("Задачи: ");
            System.out.println("1. Закончить программу");
            System.out.println("2. Добавить обувь");
            System.out.println("3. список обуви");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Покупка покупателем продукта");
            System.out.println("7. Оборот магазина за все время работы");
            System.out.println("8. Добавить денег покупателю ");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 1:
                    repeat = false;
                    break;
                case 2:
                    System.out.println("2. Добавить обувь");
                    System.out.print("Введите название обуви: ");
                    String prodName = scanner.nextLine();
                    System.out.print("Введите цену обуви: ");
                    String price= scanner.nextLine();
                    System.out.print("Введите количество пар: ");
                    String quantity= scanner.nextLine();
                    
                    Product product = createProd(prodName,new Integer(quantity), new Integer(price));
                    products.add(product);
                    
                    dataManager.saveProducts(products);
                    break;

                case 3:
                    productManager.printListProducts(products);
                    break;
                            
                    
                case 4:
                    
                    addClient(clientManager.createClient());
                    dataManager.saveClients(clients);
                    break;
                case 5:
                    System.out.println("5. Список клиентов");
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.printf("%d. %s %s. щет: %s%n"
                                ,i+1
                                ,clients.get(i).getFirstname()
                                ,clients.get(i).getLastname()
                                ,clients.get(i).getMony()
                        );
                    }
                    break;
                case 6:
                    System.out.println("Покупка покупателем продукта");
                    Purchase history=historyManager.takeOnProduct(products, clients);
                    if(history != null)  {
                    
                    }
                                    
                    dataManager.saveClients(clients);
                    dataManager.saveHistories(histories);
                   
                    dataManager.saveProducts(products);
                    break;
                case 7:
                    System.out.println("7. Оборот магазина за все время работы");                    
                    
                    break;  
                case 8:
                    System.out.println("8. Пополнить счет");
                    clientManager.Refill(clients);
                    dataManager.saveClients(clients);
                    break;    
                   
                   
            }
        }while(repeat);
}
   
   public Product createProd(String prodName,int quantity, int price){
        Product product = new Product();
        product.setProdName(prodName);
        product.setQuantity(quantity);
        product.setPrice(price);
        return product;
   }
private void addClient(Client client) {
        
        
        this.clients.set(this.clients.size() - 1, client);   
    }
    private void addHistory(Purchase histories) {
       
        this.histories.set(this.histories.size() - 1, histories);   
    }}

