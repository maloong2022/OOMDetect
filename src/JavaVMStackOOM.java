/**
 * VM Args: -Xss100M(请在 32位系统下运行）
 */

public class JavaVMStackOOM {
    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();

    }

    private void dontStop(){
        while (true){}
    }

    public void stackLeakByThread() {
        while (true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}
