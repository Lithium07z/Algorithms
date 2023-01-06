package algo_10_20195138;

import java.util.*;

class Edge implements CompKey {
    int head;
    int tail;
    int weight;

    public Edge(int h, int t, int w) {
        head = h;
        tail = t;
        weight = w;
    }
  
    public int compareTo(Object value) {
        int a = this.weight;
        int b = ((Edge)value).weight;
        return a - b;
    }
}



