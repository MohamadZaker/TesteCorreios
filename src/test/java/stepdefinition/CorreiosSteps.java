package stepdefinition;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.CorreiosPage;

public class CorreiosSteps {

    CorreiosPage correiosPage = new CorreiosPage();

    @Dado("que estou no site dos correios")
    public void que_estou_no_site_dos_correios() {
        correiosPage.entrarNoSiteDosCorreios();
    }
    @Quando("realizar a busca por {string}")
    public void realizar_a_busca_por(String string) {
        correiosPage.realizarABusca(string);
    }
    @Então("sera mostrado o resultado no log")
    public void sera_mostrado_o_resultado_no_log() {
        correiosPage.mostrarResultadoLog();
    }


}
