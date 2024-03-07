package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        // Создаем экземпляр потокобезопасного листа
        SafetyList safetyList = new SafetyList();

        // Создаем и запускаем два потока
        Thread thread1 = new Thread(new ListThread(safetyList));
        Thread thread2 = new Thread(new ListThread(safetyList));
        thread1.start();
        thread2.start();

        // Дожидаемся окончания работы потоков
        thread1.join();
        thread2.join();

        // Выводим на экран количество элементов в листе
        System.out.println("Number of elements in the list: " + safetyList.getSize());
        // END
    }
}

