package Simple;

import java.io.*;
import java.util.Random;

public class JsonFieldNamingComparator {

    public static void main(String[] args) {
        try {
            // Создание команды для выполнения cURL запроса
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "curl",
                    "--location",
                    "https://test-basket.fullstack.vkusvill.ru/api/v1/cart?new=1",
                    "--header", "user-agent: vkusvill/3.0.22 (Android; 30)",
                    "--header", "authorization: Basic dmt1c3ZpbGw6NjckI2hqZGZAQA==",
                    "--header", "x-vkusvill-device: xiaomi",
                    "--header", "x-vkusvill-source: 4",
                    "--header", "x-vkusvill-version: 3.0.22 (300022)",
                    "--header", "x-vkusvill-token: eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJjYXJkIjoiRzkxNjE0NyIsInZlcnNpb24iOjJ9.gfZCLsOyXFiMcbpQvLJ6O1uOeIm08sPwyOJZHl7vLYDGptdkB_8-02EwUS-yVHkGNp8Mnb3oi4lHbnRbYKtfRVUD23HrH82j82mPU4Ok_I1hlozm6aucZKJbIzIwqAlyEXTBz9FBVGmXJuJhqvzzgtbzp1lj0IfQtNqU6vu1XK4",
                    "--header", "x-vkusvill-model: Xiaomi Redmi Note 8 Pro",
                    "--header", "x-vkusvill-number: G916147"
            );

            // Установка перенаправления стандартного вывода и стандартной ошибки в потоки Java
            processBuilder.redirectErrorStream(true);

            // Запуск команды
            Process process = processBuilder.start();

            // Получение вывода команды
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            boolean foundStatusSuccess = false; // Флаг для определения нахождения "status : success"
            while ((line = reader.readLine()) != null) {
                if (!foundStatusSuccess && line.contains("\"status\":\"success\"")) {
                    foundStatusSuccess = true;
                }
                if (foundStatusSuccess) {
                    response.append(line);
                    response.append("\n"); // Добавляем новую строку
                }
            }

            // Ожидание завершения выполнения команды
            int exitCode = process.waitFor();
            System.out.println("Выполнение cURL запроса завершено. Код завершения: " + exitCode);

            // Преобразование тела ответа в строку
            String responseJson = response.toString();

            // Удаление кавычек и скобок
            //responseJson = responseJson.replaceAll("[\"{}]", "");

            // Разделение на новые строки между полями и значениями и добавление двоеточия
            //responseJson = responseJson.replaceAll("[:,]", " : ");

            // Вывод тела ответа в консоль
            System.out.println(formatJson(responseJson));

            // Генерация случайного имени файла
            String fileName = generateRandomFileName();

            // Сохранение в файл
            saveToFile(fileName, formatJson(responseJson));

            System.out.println("Результат сохранен в файл: " + fileName);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomFileName() {
        Random rand = new Random();
        return "response_" + rand.nextInt(1000) + ".json";
    }

    private static void saveToFile(String fileName, String content) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String formatJson(String json) {
        StringBuilder formattedJson = new StringBuilder();
        String[] lines = json.split("\n");
        int indentationLevel = 0;
        for (String line : lines) {
            if (line.contains("}")) {
                indentationLevel--;
            }
            for (int i = 0; i < indentationLevel; i++) {
                formattedJson.append("\t");
            }
            formattedJson.append(line.trim());
            formattedJson.append("\n");
            if (line.contains("{")) {
                indentationLevel++;
            }
        }
        return formattedJson.toString();
    }
}