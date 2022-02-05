//给你一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例： 
//
// 
// 线程 A 将会调用 foo() 方法，而 
// 线程 B 将会调用 bar() 方法 
// 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："foobar"
//解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出："foobarfoobar"
//解释："foobar" 将被输出两次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 多线程 
// 👍 142 👎 0

package io.github.spafka.leetcode.editor.cn;

import java.util.concurrent.Semaphore;

/**
 * @date 2022-02-04 23:19:12
 * @see {https://leetcode-cn.com/problems/print-foobar-alternately}
 **/
public class Code_1115_PrintFoobarAlternately {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FooBar {
        private int n;

        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {

                a.acquire(1);
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                b.release(1);

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                b.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                a.release(1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}