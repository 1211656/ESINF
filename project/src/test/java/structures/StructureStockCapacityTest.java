package structures;

import domain.Country;
import domain.Supercharger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StructureStockCapacityTest {

    private StructureStockCapacity structureStockCapacity = new StructureStockCapacity();

    StructureStockCapacityTest() throws IOException {
    }

    @Test
    void buscarEstadosComMaisCapacidadeArmazenamento() {
        List<Country> paises = new ArrayList<>();
        paises.add(new Country("Portugal"));
        List<Supercharger> superchargers = structureStockCapacity.buscarEstadosComMaisCapacidadeArmazenamento(paises,4);
        for (int i = 0; i < superchargers.size(); i++) {
            System.out.println(superchargers.get(i).getCapacidadeArmazenamento());
        }
    }

    @Test
    void testBuscarEstadosComMaisCapacidadeArmazenamento() {
    }
}