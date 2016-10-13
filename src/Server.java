import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Server implements Runnable{
    
    private static Socket socket; 
    private static ServerSocket server;
    private static ObjectInputStream in; 
    private static ObjectOutputStream out; 
    private static Connection connection; 
    private static Statement statement; 
    private static PreparedStatement prep;
    private static ArrayList<Customer> customerList; 
    private static ArrayList<DVD> dvdList; 
    //
    public static String name; 
    public static String surname; 
    public static String phoneNumber; 
    //
    public static String title; 
    public static String cat; 
    public static String year; 
    private static int dvdNumber;
    private static int number; 
    //
    private static String cusNumber; 
    private static String rentdvdNumber; 
    private static int rentalNumber; 
    private static String currentDate; 
    private static String dateReturned; 
    private static double credit  = 0; 
    private static boolean newRelease; 
    private static double price = 0; 
    private static String newmm = ""; 
    private static String newdd = ""; 
    private static String path = null; 
    
    @Override
    public void run() {
        
        //creates server socket
        try
        {
            server = new ServerSocket(30000);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        JFileChooser chooser = new JFileChooser("Please select database file");
        FileFilter filter = new FileNameExtensionFilter("database files", "db");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null); 
        
        try
        {
            path = chooser.getSelectedFile().getCanonicalPath(); 
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            
        Class.forName("org.sqlite.JDBC"); 

        connection = DriverManager.getConnection("jdbc:sqlite:"+path); 
        statement =  connection.createStatement(); 
        
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
         
         
        //Client accept connection
        try
        {
        System.out.println("Waiting for client connection...");
        socket = server.accept(); 
        System.out.println("Client has connected");
        out = new ObjectOutputStream(socket.getOutputStream()); 
        out.flush();
        in = new ObjectInputStream(socket.getInputStream()); 
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        
        String clientMessage; 
        try
        {
        
            while((clientMessage = (String)in.readObject()) != null){

            String command = clientMessage.substring(0, 6);
            switch(command){
               
               case "tableC": 
                  try{
                    
                    prep = connection.prepareStatement("select * from customer");
                    ResultSet content = prep.executeQuery(); 
                    customerList = new ArrayList<Customer>();
                    while(content.next()){
                        
                    int number = content.getInt(1); 
                    String name = content.getString(2); 
                    String surname = content.getString(3); 
                    String phoneNumber = content.getString(4); 
                    double credit = content.getDouble(5); 
                    boolean canRent = content.getBoolean(6); 
                    Customer cus = new Customer(number, name, surname, phoneNumber, credit, canRent);
                    customerList.add(cus); 
                    }
                    out.writeObject(customerList);
                     }catch(SQLException e){
                     e.printStackTrace();
                    }
                       break; 
                       
                       //case to add new user to database
                case "addNew": 
                    
                        String newMessage = clientMessage.substring(6);
                       
                       
                        
                        StringTokenizer token = new StringTokenizer(newMessage, "#");
                        while(token.hasMoreElements()){
                        name = token.nextToken(); 
                        surname = token.nextToken();
                        phoneNumber = token.nextToken(); 
                                
                        }
                       
                        //generates random customer number
                        Random rand = new Random();
                        int cusNum = rand.nextInt(1000)+1;
                        try{
                        prep = connection.prepareStatement("select * from customer where custNumber = ?"); 
                        prep.setInt(1, cusNum);
                        ResultSet rs = prep.executeQuery(); 
                        while(rs.next()){
                            
                            int newNum = rand.nextInt(1000)+1;
                            cusNum = newNum; 
                            }
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                       
                        double credit = 100.0; 
                        boolean canRent = true; 
                        
                     try(PreparedStatement prep = connection.prepareStatement("insert into customer(custNumber,"
                             + " firstName, surname, "
                  + "phoneNumber, credit, canRent) values(?, ?, ?, ?, ?, ?)")){
          
                    prep.setInt(1, cusNum);
                    prep.setString(2, name);
                    prep.setString(3, surname);
                    prep.setString(4, phoneNumber);
                    prep.setDouble(5, credit);
                    prep.setBoolean(6, canRent);
                    prep.executeUpdate(); 
                    
                    try{
                    out.writeObject("New customer was added");
                    }catch(IOException e){
                    e.printStackTrace();
                    }
              
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                    
                    break; 
                    
                    //case to remove user from database
                case "remove": 
                    
                        String nameToRemove = clientMessage.substring(6);
                       
                        try(PreparedStatement prep = connection.prepareStatement("delete from customer where custNumber = ?")){
          
                            prep.setString(1, nameToRemove);
                            prep.executeUpdate(); 
                    
              
                        }catch(SQLException e){
                           e.printStackTrace();
                        }
                    
                    break; 
                    //case to get dvd table contents
                case "dvdTab": 
                    
                case "addDvd": 
                    
                case "remDvd": 
                    
                case "rentDv": 
                   
                case "rental": 
                    
                case "dayRen":
                       
                   }
            
        
        }
        
       socket.close();
       server.close();
       out.close();
       in.close();
        
        }catch(IOException e){
        e.printStackTrace();
       }catch(ClassNotFoundException e){
       e.printStackTrace();
        }
         
    }
    
    public static void main(String[] args)
    {
        // Create application
        Server server = new Server();
        
        // Start waiting for connections
        server.run();
    }    
        
    }
        
    

      

    
