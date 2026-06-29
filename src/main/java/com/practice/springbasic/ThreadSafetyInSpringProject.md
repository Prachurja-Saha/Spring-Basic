## No instance variables → Thread-safe ✅

Due to singleton scope There can be thread safety issue for concurrent multiple thread
example ->
@RestController
public class CounterController {
    private int counter = 0;  // Shared mutable state [can be fixed by synchronized, atomicity, ThreadLocal

    @GetMapping("/increment")
    public int increment() {
        counter++;  // Not thread-safe
        return counter;
    }
}

Thread Safe ->
@RestController
public class SafeController {
    @GetMapping("/safe-increment")
    public int increment(@RequestParam int value) {
        return value + 1;  // No shared state
    }
}

