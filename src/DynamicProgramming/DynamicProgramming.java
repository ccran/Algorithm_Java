package DynamicProgramming;

/**
 * 动态规划学习
 */
public class DynamicProgramming {
    /**
     * 斐波那契数
     *
     * @param n
     * @return
     */
    //递归方式
    public static int fib_Recursion(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib_Recursion(n - 1) + fib_Recursion(n - 2);
    }

    //备忘录
    public static int fibonacci(int n) {
        int[] Memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Memo[i] = -1;
        }
        return fib(n, Memo);
    }

    public static int fib(int n, int[] Memo) {
        if (n == 0)
            Memo[0] = 0;
        if (n == 1)
            Memo[1] = 1;
        if (Memo[n] != -1) {
            return Memo[n];
        }
        Memo[n] = fib(n - 1, Memo) + fib(n - 2, Memo);
        return Memo[n];
    }

    //自底向上
    public static int fib_Array(int n) {
        int[] Memo = new int[n + 1];
        Memo[0] = 0;
        Memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            Memo[i] = Memo[i - 1] + Memo[i - 2];
        }
        return Memo[n];
    }

    //节约空间
    public static int fib_Variable(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int a = 0, b = 1, c = 1;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    /**
     * 钢材切割
     *
     * @param n
     * @return
     */
    //切割的递归方法
    public static int cut_Recursion(int[] p, int n) {
        if (n == 0)
            return 0;
        else {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, p[i] + cut_Recursion(p, n - i));
            }
            return max;
        }
    }

    //备忘录记录
    public static int cut_Memo(int[] p, int n) {
        int[] Memo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Memo[i] = -1;
        }
        return cut_Memo(p, n, Memo);
    }


    public static int cut_Memo(int[] p, int n, int[] Memo) {
        if (n == 0)
            return 0;
        if (Memo[n] != -1)
            return Memo[n];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, p[i] + cut_Memo(p, n - i, Memo));
        }
        Memo[n] = max;
        return Memo[n];
    }

    //自底向上
    public static int cut(int[] p, int n) {
        int[] dp = new int[n + 1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],p[j]+dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //fib
        System.out.println(fib_Variable(6));
        //cut
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cut_Memo(price, 4));
        System.out.println(cut(price, 4));
    }
}
