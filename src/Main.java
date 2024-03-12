import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Notebook> notebookHashMap = new HashMap<>();
        Notebook notebook1 = new Notebook(8, 128, "Linux", "black", "AMD", "AMD");
        Notebook notebook2 = new Notebook(16, 256, "Linux", "white", "AMD", "AMD");
        Notebook notebook3 = new Notebook(32, 512, "Windows", "blue", "Nvidia", "Intel");
        Notebook notebook4 = new Notebook(64, 1024, "Windows", "gold", "Nvidia", "Intel");

        notebookHashMap.put(1, notebook1);
        notebookHashMap.put(2, notebook2);
        notebookHashMap.put(3, notebook3);
        notebookHashMap.put(4, notebook4);

        filterNotebook(notebookHashMap);
    }

    public static void filterNotebook(HashMap<Integer, Notebook> notebookHashMap) {
        boolean continueSelect = true;
        ArrayList<Integer> chosenCategory = new ArrayList<>();
        HashMap<Integer, String> chosenCategoryAndValue = new HashMap<Integer, String>();
        HashMap<Integer, Notebook> notebookFilter = new HashMap<Integer, Notebook>();

        notebookFilter = notebookHashMap;

        System.out.println("""
                Выберите необходимые параметры:
                1. Объем оперативной памяти
                2. Объем жестких дисков
                3. Операционная система
                4. Цвет ноутбука
                5. Производитель видеокарты 
                6. Производитель процессора
                
                0 - Закончить процесс выбора категорий
                
                """);
        Scanner scanner = new Scanner(System.in);

        while (continueSelect) {
            System.out.print("Введите номер параметра: ");
            int choose = scanner.nextInt();
            if (choose == 0) {
                continueSelect = false;
            } else {
                chosenCategory.add(choose);
            }
        }

        Collections.sort(chosenCategory);

        System.out.println("""
                
                
                Введите нужное вам значение, соответствующую необходимому критерию:
                1. Объем оперативной памяти (8-64 ГБ)
                2. Объем жестких дисков (128-1024)
                3. Операционная система (Windows/Linux)
                4. Цвет ноутбука (black/white/blue/gold)
                5. Производитель видеокарты (Nvidia/AMD)
                6. Производитель процессора (AMD/Intel)
                """);

        String value = scanner.nextLine();

        for (Integer item : chosenCategory) {
            System.out.println("Введите минимальное значение фильтрации для выбранной категории " + item);
            String value1 = scanner.nextLine();
            chosenCategoryAndValue.put(item, value1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        try {
            for (Integer integer : chosenCategory) {
                switch (integer) {
                    case (1):
                        for (Integer id : notebookFilter.keySet()) {
                            if (Integer.parseInt(chosenCategoryAndValue.get(1)) > notebookFilter.get(id).getCapacityRAM()) {
                                list.add(id);
                            }
                        }
                        break;
                    case (2):
                        for (Integer id : notebookFilter.keySet()) {
                            if (Integer.parseInt(chosenCategoryAndValue.get(2)) > notebookFilter.get(id).getCapacityMemory()) {
                                list.add(id);
                            }
                        }
                        break;
                    case (3):
                        for (Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(3).equals(notebookFilter.get(id).getOperatingSystem())) {
                                list.add(id);
                            }
                        }
                        break;
                    case (4):
                        for (Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(4).equals(notebookFilter.get(id).getColore())) {
                                list.add(id);
                            }
                        }
                        break;
                    case (5):
                        for (Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(5).equals(notebookFilter.get(id).getVideoCard())) {
                                list.add(id);
                            }
                        }
                        break;
                    case (6):
                        for (Integer id : notebookFilter.keySet()) {
                            if (!chosenCategoryAndValue.get(6).equals(notebookFilter.get(id).getProcessor())) {
                                list.add(id);
                            }
                        }
                        break;
                }
            }
        } catch (Exception ignored) {
        }

        for (Integer integer : list) {
            notebookFilter.remove(integer);
        }

        for (Notebook item : notebookFilter.values()) {
            System.out.println(item);
        }
    }
}

