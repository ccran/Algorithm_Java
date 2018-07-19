import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //排序
        int[] arr = {-1, -2, -5, 5, 3, 2, 1};
        Arrays.sort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
        //
        boolean[][] visited = new boolean[1][1];
        System.out.println(visited[0][0]);
    }
}
