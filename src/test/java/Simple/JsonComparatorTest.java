package Simple;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonComparatorTest {

    @Test
    public void compareJsonFiles() throws IOException, JSONException {
        // Загрузка эталонного JSON-файла
        String expectedJson = new String(Files.readAllBytes(Paths.get("responseAllCart.json"))); // базовый респонс с которым сверяем
        JSONObject expectedJsonObject = new JSONObject(expectedJson);

        // Загрузка тестируемого JSON-файла
        String actualJson = new String(Files.readAllBytes(Paths.get("response_719.json")));
        JSONObject actualJsonObject = new JSONObject(actualJson);

        // Создание объекта SoftAssert для мягких проверок
        SoftAssert softAssert = new SoftAssert();

        // Сравнение всех полей, объектов, массивов и значений
        compareJsonObjects(expectedJsonObject, actualJsonObject, softAssert);

        // Проверка, есть ли какие-либо ошибки
        softAssert.assertAll();
    }

    private void compareJsonObjects(JSONObject expected, JSONObject actual, SoftAssert softAssert) {
        Iterator<String> keys = expected.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!actual.has(key)) {
                // Если поле отсутствует в тестируемом JSON-файле
                softAssert.fail("Не найдено поле: " + key);
            } else {
                Object expectedValue = expected.get(key);
                Object actualValue = actual.get(key);

                String expectedType = expectedValue.getClass().getSimpleName();
                String actualType = actualValue.getClass().getSimpleName();
                String expectedTypeWithValue = expectedValue + " (" + expectedType + ")";
                String actualTypeWithValue = actualValue + " (" + actualType + ")";

                if (expectedType.equals(actualType)) {
                    // Проверка на совпадение типов значений
                    softAssert.assertTrue(true, "Тип значения поля " + key + " соответствует ожидаемому: " +
                            "ожидаемый тип - " + expectedTypeWithValue + ", фактический тип - " + actualTypeWithValue);
                } else {
                    softAssert.fail("Тип значения поля " + key + " не соответствует ожидаемому: " +
                            "ожидаемый тип - " + expectedTypeWithValue + ", фактический тип - " + actualTypeWithValue);
                }

                if (expectedValue instanceof JSONObject && actualValue instanceof JSONObject) {
                    // Рекурсивное сравнение вложенных объектов
                    compareJsonObjects((JSONObject) expectedValue, (JSONObject) actualValue, softAssert);
                } else if (expectedValue instanceof Map && actualValue instanceof Map) {
                    // Рекурсивное сравнение вложенных массивов
                    compareJsonArrays((Map) expectedValue, (Map) actualValue, softAssert);
                }
            }
        }

        // Проверка на наличие лишних полей в actual
        Iterator<String> actualKeys = actual.keys();
        while (actualKeys.hasNext()) {
            String key = actualKeys.next();
            if (!expected.has(key)) {
                Object actualValue = actual.get(key);
                String actualType = actualValue.getClass().getSimpleName();
                String actualTypeWithValue = actualValue + " (" + actualType + ")";
                softAssert.fail("Лишнее поле в actual: " + key + ", значение: " + actualTypeWithValue);
            }
        }
    }

    private void compareJsonArrays(Map expected, Map actual, SoftAssert softAssert) {
        for (Object key : expected.keySet()) {
            if (!actual.containsKey(key)) {
                // Если ключ отсутствует в тестируемом массиве
                softAssert.fail("Не найден элемент: " + key);
            } else {
                Object expectedValue = expected.get(key);
                Object actualValue = actual.get(key);

                String expectedType = expectedValue.getClass().getSimpleName();
                String actualType = actualValue.getClass().getSimpleName();
                String expectedTypeWithValue = expectedValue + " (" + expectedType + ")";
                String actualTypeWithValue = actualValue + " (" + actualType + ")";

                if (expectedType.equals(actualType)) {
                    // Проверка на совпадение типов значений
                    softAssert.assertTrue(true, "Тип значения элемента " + key + " соответствует ожидаемому: " +
                            "ожидаемый тип - " + expectedTypeWithValue + ", фактический тип - " + actualTypeWithValue);
                } else {
                    softAssert.fail("Тип значения элемента " + key + " не соответствует ожидаемому: " +
                            "ожидаемый тип - " + expectedTypeWithValue + ", фактический тип - " + actualTypeWithValue);
                }

                if (expectedValue instanceof Map && actualValue instanceof Map) {
                    // Рекурсивное сравнение вложенных объектов в массивах
                    compareJsonObjects(new JSONObject((Map) expectedValue), new JSONObject((Map) actualValue), softAssert);
                } else if (expectedValue instanceof Map && actualValue instanceof JSONObject) {
                    // Сравнение объекта с объектом в массиве
                    compareJsonObjects(new JSONObject((Map) expectedValue), (JSONObject) actualValue, softAssert);
                } else if (expectedValue instanceof JSONObject && actualValue instanceof Map) {
                    // Сравнение объекта в массиве с объектом
                    compareJsonObjects((JSONObject) expectedValue, new JSONObject((Map) actualValue), softAssert);
                }
            }
        }

        // Проверка на наличие лишних элементов в actual
        Iterator<Map.Entry<String, Object>> entryIterator = actual.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> entry = entryIterator.next();
            String key = entry.getKey();
            if (!expected.containsKey(key)) {
                Object actualValue = entry.getValue();
                String actualType = actualValue.getClass().getSimpleName();
                String actualTypeWithValue = actualValue + " (" + actualType + ")";
                softAssert.fail("Лишний элемент в actual: " + key + ", значение: " + actualTypeWithValue);
            }
        }
    }
}