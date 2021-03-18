package Ekstraoppgave;

import java.util.*;

public class EkstraOppgave {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long startTid = System.nanoTime();
        for(int i = 0; i < 400000; i++) {
            list.add(i);
        }
        long sluttTid = System.nanoTime();
        System.out.println((sluttTid-startTid)/1_000_000);

        Stack<Integer> stack = new Stack<>();
        startTid = System.nanoTime();
        for(int i = 0; i < 400000; i++) {
            stack.add(i);
        }
        sluttTid = System.nanoTime();
        System.out.println((sluttTid-startTid)/1_000_000);

        Vector<Integer> vector = new Vector<>();
        startTid = System.nanoTime();
        for(int i = 0; i < 400000; i++) {
            vector.add(i);
        }
        sluttTid = System.nanoTime();
        System.out.println((sluttTid-startTid)/1_000_000);

        Map<Integer, Integer> map = new HashMap<>();
        startTid = System.nanoTime();
        for(int i = 0; i < 400000; i++) {
            map.put(i, i);
        }
        sluttTid = System.nanoTime();
        System.out.println((sluttTid-startTid)/1_000_000);

        int[] arr = new int[400000];
        startTid = System.nanoTime();
        for(int i = 0; i < 400000; i++) {
            arr[i] = i;
        }
        sluttTid = System.nanoTime();
        System.out.println((sluttTid-startTid)/1_000_000);
    }
}
