import java.util.HashSet;
import java.util.Set;

/** VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M */
public class RuntimeConstantPoolOOM {
  public static void main(String[] args) {
    // 使用 Set 保持着常量池引用，避免 FullGC 回收常量池行为
    Set<String> set = new HashSet<String>();
    // 在 short 范围内足以让 6M 的 PermSize 产生 OOM了
    short i = 0;
    while (true) {
      set.add(String.valueOf(i++).intern());
    }
  }
}
