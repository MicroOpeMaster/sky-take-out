package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<Integer> groups = new ArrayList<>();
        findGroups(0, 0, 0, groups, arr, new boolean[10]);
        int sum = Arrays.stream(arr).reduce(Integer::sum).orElse(0);
        int res = groups.stream().map(a -> Math.abs(2 * a - sum)).min((a, b) -> a - b).orElse(0);
        System.out.println(res);
    }

    public static void findGroups(int index, int count, int sum, ArrayList<Integer> groups, int[] arr, boolean[] visited) {
        if (count == 5) {
            groups.add(sum);
            return;
        }
        for (int i = index; i < 10; i++) {
            if (visited[i] || (i > index && arr[i] == arr[i - 1]))
                continue;
            visited[i] = true;
            findGroups(index + 1, count + 1, sum + arr[i], groups, arr, visited);
            visited[i] = false;
        }
    }
}