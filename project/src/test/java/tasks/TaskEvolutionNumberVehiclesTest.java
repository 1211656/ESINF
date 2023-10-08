package tasks;

import domain.Country;
import domain.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskEvolutionNumberVehiclesTest {

    private TaskEvolutionNumberVehicles task;
    private Map<Sale, Integer> sampleMap;

    @BeforeEach
    public void setUp() {
        task = new TaskEvolutionNumberVehicles();
        sampleMap = new HashMap<>();
    }

    @Test
    public void testGetMapOfCountries() {
        // Criar dados de teste
        Country country = new Country("Portugal");
        Sale sale1 = new Sale("Sale1", "Portugal", "2022", "100"); // Ano e veículos vendidos como String
        Sale sale2 = new Sale("Sale2", "Portugal", "2023", "200"); // Ano e veículos vendidos como String
        sampleMap.put(sale1, 100);
        sampleMap.put(sale2, 200);

        // Chamar o método getMapOfCountries
        Map<Sale, Integer> result = task.getMapOfCountries(country, sampleMap);

        // Verificar se o mapa resultante contém as vendas do país
        assertTrue(result.containsKey(sale1));
        assertTrue(result.containsKey(sale2));
        assertFalse(result.containsKey(new Sale("Sale3", "Espanha", "2022", "50"))); // Verificar que não contém dados de outro país
    }

    @Test
    public void testSearchIfBothYearsAreInMap() {
        // Criar dados de teste
        Country country = new Country("Portugal");
        Sale sale1 = new Sale("Sale1", "Portugal", "2022", "100"); // Ano e veículos vendidos como String
        Sale sale2 = new Sale("Sale2", "Portugal", "2023", "200"); // Ano e veículos vendidos como String
        sampleMap.put(sale1, 100);
        sampleMap.put(sale2, 200);

        // Verificar se ambos os anos estão no mapa
        assertTrue(task.searchIfBothYearsAreInMap(2022, 2023, country, sampleMap));

        // Verificar quando um dos anos não está no mapa
        assertFalse(task.searchIfBothYearsAreInMap(2022, 2024, country, sampleMap));
    }

    @Test
    public void testGetMapByYearsAndCountry() {
        // Criar dados de teste
        Country country = new Country("Portugal");
        Sale sale1 = new Sale("Sale1", "Portugal", "2022", "100"); // Ano e veículos vendidos como String
        Sale sale2 = new Sale("Sale2", "Portugal", "2023", "200"); // Ano e veículos vendidos como String
        sampleMap.put(sale1, 100);
        sampleMap.put(sale2, 200);

        // Obter um mapa filtrado por anos e país
        Map<Sale, Integer> result = task.getMapByYearsAndCountry(2022, 2023, sampleMap);

        // Verificar se o mapa resultante contém as vendas corretas
        assertTrue(result.containsKey(sale1));
        assertTrue(result.containsKey(sale2));
        assertFalse(result.containsKey(new Sale("Sale3", "Portugal", "2024", "50"))); // Verificar que não contém dados de outro ano
    }
}