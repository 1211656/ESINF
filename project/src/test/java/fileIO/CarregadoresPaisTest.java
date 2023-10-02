package fileIO;

import org.junit.jupiter.api.Test;

public class CarregadoresPaisTest implements Files{

    @Test
    void getChargersCountry() {
        CarregadoresCidade carregadoresCidade = new CarregadoresCidade();
        carregadoresCidade.GetChargers(CarregadoresFile);
        carregadoresCidade.contaCarregadorPais();
    }
}
