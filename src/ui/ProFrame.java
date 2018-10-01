package ui;

import model.TableModel;
import model.ToDoItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;


public class ProFrame extends JFrame {

    static int width = 800;
    static int height = 600;

    private TableModel model;




    public static void main(String... args) {
        ProFrame proFrame = new ProFrame();
        proFrame.init(width, height);
    }


    private void init(int width, int height){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(width, height);
        setTitle("Programování 2");

        JPanel toolbar = new JPanel();
        add(toolbar, BorderLayout.NORTH);


        JButton button = new JButton();
        button.setText("Přidat poznámku");
        toolbar.add(button);

        button.addActionListener(action->{
            ToDoItem item = new ToDoItem("test obsah");
            model.add(item);
        } );

        JButton button2 = new JButton();
        button2.setText("Uložit");
        toolbar.add(button2);

        button2.addActionListener(action->{
           saveItems();
        } );
        JButton button3 = new JButton();
        button3.setText("Načíst");
        toolbar.add(button3);

        button3.addActionListener(action->{
         loadItems();
        } );




        model = new TableModel();

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        pack();

        setLocationRelativeTo(null);

    }


    private void saveItems(){
        try{


        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("our.db")));

        stream.writeObject(model.getItems());;

        stream.flush();
        stream.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        }

    private void loadItems(){
        try{
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("our.db")));

            List<ToDoItem> items = (List<ToDoItem>) stream.readObject();
            stream.close();
            model.setItems(items);
            model.fireTableDataChanged();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
