class SumArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum of all elements: " + sum);
    }
}
