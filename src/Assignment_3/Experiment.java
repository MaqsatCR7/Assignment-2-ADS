package Assignment_3;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long startTime = System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(arr);
        else if (type.equals("advanced")) sorter.advancedSort(arr);
        return System.nanoTime() - startTime;
    }

    public void runAllExperiments() {
        // Тапсырма бойынша 10, 100, 1000 өлшемдері 
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("\n--- Array Size: " + size + " ---");
            int[] arr = sorter.generateRandomArray(size);

            // Сұрыптау уақытын өлшеу
            long basicTime = measureSortTime(arr.clone(), "basic");
            long advTime = measureSortTime(arr.clone(), "advanced");

            System.out.println("Insertion Sort Time: " + basicTime + " ns");
            System.out.println("Quick Sort Time: " + advTime + " ns");
        }
    }
}
