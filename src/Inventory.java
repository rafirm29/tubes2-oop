package src;
import java.util.ArrayList;
import java.util.List;

public class Inventory<T>{
    int capacity;
    int max_capacity;
    List<T> inventory;

    public Inventory(int x){
        this.max_capacity=x;
        this.capacity=0;
        this.inventory= new ArrayList<T>();
        System.out.println("Inventory dengan kapasitas "+ this.max_capacity);
    }

    public void add(T x){
        if(this.capacity >= this.max_capacity){
            System.out.println("Inventory penuh");
        }
        else{
            this.inventory.add(x);
            this.capacity= this.capacity+1;
        }
    }

    public void remove(T x){
        int i=0;
        for (T t : inventory) {
            if(t.equals(x)){
                this.inventory.remove(i);
                this.capacity=this.capacity - 1;
                break;
            }
            i++;
        }
    }
    public void info(){
        for (T t : inventory) {
            System.out.println(t);
        }
    }
    public List<T> getList(){
        return this.inventory;
    }
    public int getCapacity(){
        return this.capacity;
    }
}