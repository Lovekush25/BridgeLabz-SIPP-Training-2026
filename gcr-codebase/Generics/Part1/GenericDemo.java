import java.util.Arrays;

public class GenericDemo {

    public static void main(String[] args) {

        Pair<String, Integer> pair =
                new Pair<>("Laptop", 65000);

        System.out.println("Pair");
        System.out.println(pair);

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println();
        System.out.println("Stack");

        System.out.println("Top : " + stack.peek());
        System.out.println("Removed : " + stack.pop());
        System.out.println("Top : " + stack.peek());

        Integer[] numbers = {14, 52, 33, 91, 27};

        System.out.println();
        System.out.println("Maximum : " + GenericUtility.findMax(numbers));

        Repository<String> repository = new Repository<>();

        repository.add("Java");
        repository.add("Spring Boot");
        repository.add("React");

        System.out.println();
        System.out.println("Repository Data");

        GenericUtility.print(repository.getAll());

        System.out.println();

        GenericUtility.print(Arrays.asList(1, 2, 3, 4, 5));
    }
}