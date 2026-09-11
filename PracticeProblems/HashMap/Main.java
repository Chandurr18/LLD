package PracticeProblems.HashMap;

class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("Alice", 10);
        map.put("Bob", 20);
        map.put("Alice", 30);
        map.put("Charlie", 10);
        map.put("Dan", 10);
        map.put("East", 10);
        map.put("Farhad", 10);

        System.out.println(map.get("Alice"));

        map.remove("Bob");
        map.put("Bob", 30);

        System.out.println(map.get("Bob"));
        System.out.println(map.get("Charlie"));
    }
}