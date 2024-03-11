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
                    "https://test-basket.fullstack.vkusvill.ru/api/v1/cart",
                    "--header", "user-agent: vkusvill/3.0.22 (Android; 30)",
                    "--header", "authorization: Basic dmt1c3ZpbGw6NjckI2hqZGZAQA==",
                    "--header", "x-vkusvill-device: xiaomi",
                    "--header", "x-vkusvill-source: 4",
                    "--header", "x-vkusvill-version: 3.0.22 (300022)",
                    "--header", "x-vkusvill-token: eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJjYXJkIjoiSjAyOTM2MCIsInZlcnNpb24iOjJ9.SR1Px_6UFkbHcCbroPwt0hrvzeqou3XQbaktD8INWMGSbCtHBPTHDOd5ucmllIma1dYBkCyDW8CrN6b5JglsBhYujImfT4h2o-5ZLSrSULPd7PtFuuvWlAgEjBwjCSYmQtOXr5QHZKGWZkDBL52KpXiYkKPOQmI2Nn2e-qchQZg",
                    "--header", "x-vkusvill-model: Xiaomi Redmi Note 8 Pro",
                    "--header", "x-vkusvill-number: J029360"
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

            // Получение вывода ошибок cURL
            InputStream errorStream = process.getErrorStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
            StringBuilder errorResponse = new StringBuilder();
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                errorResponse.append(errorLine);
                errorResponse.append("\n");
            }

            // Вывод ошибок cURL в консоль, если они есть
            if (errorResponse.length() > 0) {
                System.out.println("Ошибка cURL запроса: " + errorResponse.toString());
            }

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