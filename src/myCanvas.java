package pkg.graph;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class myCanvas extends Canvas{
    
    public String[] N;
    
    int size = 0;
    int[] x, y;
    
    public myCanvas(String[] nodeName){
        N = nodeName; size = N.length;
        x = new int[size];
        y = new int[size];
    }
    
    public void paint(Graphics g){
        int i = 0, j = 0;
        while(i < size){
            x[i] = this.randNum();
            y[i] = this.randNum();
            
            g.setColor(Color.BLUE);
            g.fillOval(x[i], y[i], 10, 10);
            
            g.setColor(Color.BLACK);
            g.drawString(N[i], x[i] + 12, y[i] + 9);
            g.setColor(Color.BLUE);
            
            if(i != 0){
                j = 0;
                while(j < i){
                    if(this.isConnected(N[i], N[j])){
                        g.drawLine(x[i]+5, y[i]+5, x[j]+5, y[j]+5);
                    }
                    j++;
                }
            }
            
            i++;
        }

    }
    
    private boolean isConnected(String str, String key){
        int match = 0, i = 0;
        if(str.length() != key.length()){ return false; }
        
        str = str.toLowerCase(); key = key.toLowerCase();
        while(i < key.length()){
            if(key.charAt(i) == str.charAt(i)){ match++; }
            i++;
        }
        if(match >= str.length() - 1){ return true; }
        return false;
    }
    
    public int randNum(){
        Random rGen = new Random();
        return rGen.nextInt(350);
    }
}
