public class Main {

    public static void main(String[] args) {
        int L = 5,
            N = 20;

        EncodingCollection collection = new EncodingCollection(L);

        Encoding current = collection.getRandom();
        Encoding maxS = current;
        int max = maxS.getAdaptability().square(L);

        for (int i = 0; i < N; i++) {

            System.out.println("\nШаг: " + i);
            System.out.println("Текущий max: " + max + ", текущий maxS: (" + maxS.getValue() + ") " + maxS.toString(L));

            EncodingCollection surroundings = collection.getSurroundings(maxS);

            System.out.println("Окрестность для текущего шага: " + surroundings.toString());
            while (0 < surroundings.getLength()) {
                int random = (int)(Math.random() * surroundings.getLength());
                current = surroundings.getRandom();
                System.out.println("Выбрана Si: (" + current.getValue() + ") " + current.toString(L) + ", ее приспособленность: " + current.getAdaptability().square(L));
                surroundings.asList().remove(random);
                if (max < current.getAdaptability().square(L)) {
                    maxS = current;
                    max = current.getAdaptability().square(L);
                    System.out.println("Установлено новое значение maxS: " + maxS.toString(L) + " (" + maxS.getValue() + "), и max: " + max);
                    break;
                }
            }
        }

        System.out.println("\nКонечная max: " + max + ", конечная maxS: (" + maxS.getValue() + ") " + maxS.toString(L));
    }
}
